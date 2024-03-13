package store.ojuara.pedidoapi.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.client.ProdutoClient;
import store.ojuara.pedidoapi.client.response.ProdutoResponse;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;
import store.ojuara.pedidoapi.domain.form.ItemPedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoUpdateForm;
import store.ojuara.pedidoapi.domain.model.ItemPedido;
import store.ojuara.pedidoapi.domain.model.Pedido;
import store.ojuara.pedidoapi.kafka.KafkaProducer;
import store.ojuara.pedidoapi.mapper.PedidoMapper;
import store.ojuara.pedidoapi.repository.PedidoRepository;
import store.ojuara.pedidoapi.service.validator.PedidoValidator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

    private final PedidoValidator validator;
    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final ProdutoClient client;
    private final KafkaProducer<List<ItemPedidoDTO>> kafkaProducer;

    @Override
    public PedidoDTO visualizar(Long id) {
        return mapper.toDto(validator.verificarExistencia(id));
    }

    @Override
    public PedidoDTO visualizarPorUuid(UUID uuid) {
        return mapper.toDto(validator.verificarExistencia(uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PedidoDTO> listar(Pageable paginacao) {
        var pagePedido = repository.findAll(paginacao);
        return pagePedido.map(this::toDTO);
    }

    /**TODO Implementar listagem por specification**/

    @Transactional
    @Override
    public PedidoDTO criarPedido(PedidoForm form) {
        var pedido = mapper.toModel(form);
        var valorTotal = BigDecimal.ZERO;
        for(ItemPedidoForm itemPedidoForm : form.getItens()){
            var itemPedido = mapearItemPedido(itemPedidoForm);
            valorTotal = valorTotal.add(itemPedido.getSubtotal());
            pedido.getItens().add(itemPedido);
        }
        pedido.setValorTotal(valorTotal);
        pedido.setStatus(StatusPedido.EM_PROCESSAMENTO);
        var pedidoDTO = mapper.toDto(repository.save(pedido));
        kafkaProducer.send(pedidoDTO.getItens());

        return pedidoDTO;
    }

    @Override
    public PedidoDTO atualizar(Long id, PedidoUpdateForm updateForm) {
        var pedido = validator.verificarExistencia(id);
        mapper.updatePedidoFromPedidoUpdateForm(updateForm, pedido);

        return mapper.toDto(repository.save(pedido));
    }

    @Override
    public void excluir(Long id) {
        var pedido = validator.verificarExistencia(id);
        repository.delete(pedido);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        return mapper.toDto(pedido);
    }

    private ProdutoResponse buscarProduto(UUID uuidProduto) {
        return client.buscarProduto(uuidProduto).getBody();
    }

    private ItemPedido mapearItemPedido(ItemPedidoForm form) {
        var produto = buscarProduto(form.getUuidProduto());
        validator.validarQtdProduto(produto.getQuantidade(), form.getQuantidade());
        var itemPedido = new ItemPedido();
        itemPedido.setUuidProdutoExterno(produto.getUuid());
        itemPedido.setQuantidade(form.getQuantidade());
        itemPedido.setSubtotal(produto.getPrecoVenda().multiply(BigDecimal.valueOf(form.getQuantidade())));

        return itemPedido;
    }
}

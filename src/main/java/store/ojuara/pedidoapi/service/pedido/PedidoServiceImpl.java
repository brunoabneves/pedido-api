package store.ojuara.pedidoapi.service.pedido;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import store.ojuara.pedidoapi.kafka.PedidoProducerImpl;
import store.ojuara.pedidoapi.mapper.ItemPedidoMapper;
import store.ojuara.pedidoapi.mapper.PedidoMapper;
import store.ojuara.pedidoapi.repository.ItemPedidoRepository;
import store.ojuara.pedidoapi.repository.PedidoRepository;
import store.ojuara.pedidoapi.service.validator.PedidoValidator;
import store.ojuara.pedidoapi.shared.exception.PedidoException;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private final PedidoProducerImpl pedidoProducer;
    private final ItemPedidoMapper itemPedidoMapper;
    private final ItemPedidoRepository itemPedidoRepository;

    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

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
        try {
            var pedido = mapper.toModel(form);
            var pedidoSalvo = repository.save(pedido);
            var valorTotal = BigDecimal.ZERO;
            List<ItemPedidoDTO> itensPedidoDTO = new ArrayList<>();
            List<ItemPedido> itensPedido = new ArrayList<>();

            for(ItemPedidoForm itemForm : form.getItens()) {
                var itemPedido = mapearItemPedido(itemForm);
                valorTotal = valorTotal.add(itemPedido.getSubtotal());
                itemPedido.setPedido(pedidoSalvo);
                itensPedidoDTO.add(itemPedidoMapper.toDto(itemPedido));
                itensPedido.add(itemPedido);
            }

            pedidoSalvo.setValorTotal(valorTotal);
            pedidoSalvo.setStatus(StatusPedido.EM_PROCESSAMENTO);
            pedidoSalvo.setItens(itensPedido);
            var pedidoDTO = mapper.toDto(repository.save(pedidoSalvo));
            pedidoDTO.setItens(itensPedidoDTO);
            itensPedidoDTO.forEach(pedidoProducer::send);

            return pedidoDTO;
        } catch(Exception e) {
            logger.error("Erro ao criar pedido: {}", e.getMessage());
            throw new PedidoException("Erro ao criar pedido: " + e.getMessage());
        }
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
        var itemPedido = itemPedidoMapper.toModel(form);
        itemPedido.setSubtotal(produto.getPrecoVenda().multiply(BigDecimal.valueOf(form.getQuantidade())));

        return itemPedido;
    }
}

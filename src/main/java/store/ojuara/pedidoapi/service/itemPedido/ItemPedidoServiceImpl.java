package store.ojuara.pedidoapi.service.itemPedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.client.ProdutoClient;
import store.ojuara.pedidoapi.client.response.ProdutoResponse;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;
import store.ojuara.pedidoapi.domain.form.ItemPedidoForm;
import store.ojuara.pedidoapi.domain.model.ItemPedido;
import store.ojuara.pedidoapi.mapper.ItemPedidoMapper;
import store.ojuara.pedidoapi.repository.ItemPedidoRepository;
import store.ojuara.pedidoapi.service.validator.PedidoValidator;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemPedidoServiceImpl implements ItemPedidoService{

    private final ItemPedidoRepository repository;
    private final ItemPedidoMapper mapper;
    private final PedidoValidator validator;
    private final ProdutoClient client;

    @Override
    public List<ItemPedido> salvarItensDePedido(List<ItemPedidoForm> itensForm) {
        return itensForm.stream().map(this::salvarItemPedido).collect(Collectors.toList());
    }
    private ItemPedido salvarItemPedido(ItemPedidoForm itemPedidoForm) {
        return repository.save(mapearItemPedido(itemPedidoForm));
    }

    private ItemPedido mapearItemPedido(ItemPedidoForm form) {
        var produto = buscarProduto(form.getUuidProduto());
        var itemPedido = mapper.toModel(form);

        validator.validarQtdProduto(produto.getQuantidade(), form.getQuantidade());
        itemPedido.setSubtotal(produto.getPrecoVenda().multiply(BigDecimal.valueOf(form.getQuantidade())));

        return itemPedido;
    }

    private ProdutoResponse buscarProduto(UUID uuidProduto) {
        return client.buscarProduto(uuidProduto).getBody();
    }

    @Override
    public ItemPedidoDTO visualizar(Long id){
        var itemPedido = buscarItemPedidoPorIdOuLancarExcecao(id);
        return getDTO(itemPedido);
    }

    private ItemPedido buscarItemPedidoPorIdOuLancarExcecao(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Item de pedido não encontrado"));
    }

    private ItemPedidoDTO getDTO(ItemPedido itemPedido) {
        return mapper.toDto(itemPedido);
    }
}

package store.ojuara.pedidoapi.service.itemPedido;

import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;
import store.ojuara.pedidoapi.domain.form.ItemPedidoForm;
import store.ojuara.pedidoapi.domain.model.ItemPedido;

import java.util.List;

public interface ItemPedidoService {
    List<ItemPedido> salvarItensDePedido(List<ItemPedidoForm> itensForm);
    ItemPedidoDTO visualizar(Long id);
}

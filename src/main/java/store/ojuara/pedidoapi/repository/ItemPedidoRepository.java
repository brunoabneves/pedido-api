package store.ojuara.pedidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.ojuara.pedidoapi.domain.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

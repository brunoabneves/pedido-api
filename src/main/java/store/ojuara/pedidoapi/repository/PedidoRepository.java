package store.ojuara.pedidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import store.ojuara.pedidoapi.domain.model.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {
}

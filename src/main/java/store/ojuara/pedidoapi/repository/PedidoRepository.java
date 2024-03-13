package store.ojuara.pedidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import store.ojuara.pedidoapi.domain.model.Pedido;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {
    Optional<Pedido> findByUuid(UUID uuid);
}

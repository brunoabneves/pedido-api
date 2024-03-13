package store.ojuara.pedidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import store.ojuara.pedidoapi.domain.model.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>, JpaSpecificationExecutor<Endereco> {
}

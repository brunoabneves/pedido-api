package store.ojuara.pedidoapi.service.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import store.ojuara.pedidoapi.domain.dto.ClienteDTO;
import store.ojuara.pedidoapi.domain.form.ClienteForm;
import store.ojuara.pedidoapi.domain.form.ClienteUpdateForm;

import java.util.UUID;

public interface ClienteService {

    ClienteDTO visualizar(Long id);
    ClienteDTO visualizarPorUuid(UUID uuid);
    Page<ClienteDTO> listar(Pageable paginacao);
    ClienteDTO cadastrar(ClienteForm form);
    ClienteDTO atualizar(Long id, ClienteUpdateForm updateForm);
}

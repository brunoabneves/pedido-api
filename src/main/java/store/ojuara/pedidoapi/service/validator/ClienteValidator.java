package store.ojuara.pedidoapi.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.domain.model.Cliente;
import store.ojuara.pedidoapi.repository.ClienteRepository;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteValidator {

    private final ClienteRepository repository;

    @Transactional(readOnly = true)
    public Cliente verificarExistencia(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Nenhum cliente encontrado para o id informado."));
    }

    @Transactional(readOnly = true)
    public Cliente verificarExistencia(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Nenhum cliente encontrado para o uuid informado."));
    }
}

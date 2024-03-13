package store.ojuara.pedidoapi.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.domain.model.Pedido;
import store.ojuara.pedidoapi.repository.PedidoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoValidator {

    private final PedidoRepository repository;

    @Transactional(readOnly = true)
    public Pedido verificarExistencia(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Nenhum pedido encontrado para o id informado."));
    }

    @Transactional(readOnly = true)
    public Pedido verificarExistencia(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Nenhum pedido encontrado para o uuid informado."));
    }
}

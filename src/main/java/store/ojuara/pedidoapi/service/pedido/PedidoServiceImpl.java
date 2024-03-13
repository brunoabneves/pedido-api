package store.ojuara.pedidoapi.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoUpdateForm;
import store.ojuara.pedidoapi.domain.model.Pedido;
import store.ojuara.pedidoapi.mapper.PedidoMapper;
import store.ojuara.pedidoapi.repository.PedidoRepository;
import store.ojuara.pedidoapi.service.validator.PedidoValidator;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

    private final PedidoValidator validator;
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

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

    @Override
    public PedidoDTO cadastrar(PedidoForm form) {
        var pedido = mapper.toModel(form);
        pedido.setStatus(StatusPedido.EM_PROCESSAMENTO);
        /** TODO implementar integração. Buscar produtos na api de produtos e adiciona-los ao pedido. **/
        return mapper.toDto(repository.save(pedido));
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
}

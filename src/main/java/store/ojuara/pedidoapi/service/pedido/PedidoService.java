package store.ojuara.pedidoapi.service.pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoUpdateForm;

import java.util.List;
import java.util.UUID;

public interface PedidoService {

    PedidoDTO visualizar(Long id);
    PedidoDTO visualizarPorUuid(UUID uuid);
    Page<PedidoDTO> listar(Pageable paginacao);
    PedidoDTO criarPedido(PedidoForm form);
    PedidoDTO atualizar(Long id, PedidoUpdateForm updateForm);
    void excluir(Long id);
}

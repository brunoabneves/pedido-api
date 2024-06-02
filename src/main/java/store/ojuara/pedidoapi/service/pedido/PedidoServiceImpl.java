package store.ojuara.pedidoapi.service.pedido;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoUpdateForm;
import store.ojuara.pedidoapi.domain.model.ItemPedido;
import store.ojuara.pedidoapi.domain.model.Pedido;
import store.ojuara.pedidoapi.kafka.PedidoProducerImpl;
import store.ojuara.pedidoapi.mapper.PedidoMapper;
import store.ojuara.pedidoapi.repository.PedidoRepository;
import store.ojuara.pedidoapi.service.itemPedido.ItemPedidoService;
import store.ojuara.pedidoapi.service.validator.PedidoValidator;
import store.ojuara.pedidoapi.shared.exception.PedidoException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

    private final PedidoValidator validator;
    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final PedidoProducerImpl pedidoProducer;
    private final ItemPedidoService itemPedidoService;

    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Override
    public PedidoDTO visualizar(Long id) {
        return getDTO(validator.verificarExistencia(id));
    }

    @Override
    public PedidoDTO visualizarPorUuid(UUID uuid) {
        return getDTO(validator.verificarExistencia(uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PedidoDTO> listar(Pageable paginacao) {
        var pagePedido = repository.findAll(paginacao);
        return pagePedido.map(this::getDTO);
    }

    /**TODO Implementar listagem por specification**/

    @Transactional
    @Override
    public PedidoDTO criarPedido(PedidoForm form) {
        try {
            return salvarPedidoEEnviarParaTopico(form);
        } catch(Exception e) {
            logELancamentoDeExcecao(e);
        }
        return null;
    }

    private PedidoDTO salvarPedidoEEnviarParaTopico(PedidoForm form) {
        var pedido = salvarPedido(form);
        var pedidoDTO = getDTO(pedido);
        enviarPedidoParaTopico(pedidoDTO);

        return pedidoDTO;
    }

    private Pedido salvarPedido(PedidoForm form) {
        var pedido = mapper.toModel(form);
        var itensPedido = itemPedidoService.salvarItensDePedido(form.getItens());

        pedido.setItens(itensPedido);
        pedido.setStatus(StatusPedido.EM_PROCESSAMENTO);
        pedido.setValorTotal(calcularValorTotalDoPedido(itensPedido));
        return repository.save(pedido);
    }

    private void enviarPedidoParaTopico(PedidoDTO pedidoDTO) {
        pedidoDTO.getItens().forEach(dto -> pedidoProducer.send(dto.toAvro(dto)));
    }

    private void logELancamentoDeExcecao(Exception e) {
        logger.error("Erro ao criar pedido: {}", e.getMessage());
        throw new PedidoException("Erro ao criar pedido: " + e.getMessage());
    }

    private PedidoDTO getDTO(Pedido pedido) {
        return mapper.toDto(pedido);
    }

    public BigDecimal calcularValorTotalDoPedido(List<ItemPedido> itensPedido) {
        return itensPedido.stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public PedidoDTO atualizar(Long id, PedidoUpdateForm updateForm) {
        var pedido = validator.verificarExistencia(id);
        mapper.updatePedidoFromPedidoUpdateForm(updateForm, pedido);

        return getDTO(repository.save(pedido));
    }

    @Override
    public void excluir(Long id) {
        var pedido = validator.verificarExistencia(id);
        repository.delete(pedido);
    }
}

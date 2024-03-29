package store.ojuara.pedidoapi.service.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.ojuara.pedidoapi.domain.dto.ClienteDTO;
import store.ojuara.pedidoapi.domain.enums.Genero;
import store.ojuara.pedidoapi.domain.enums.Situacao;
import store.ojuara.pedidoapi.domain.form.ClienteForm;
import store.ojuara.pedidoapi.domain.form.ClienteUpdateForm;
import store.ojuara.pedidoapi.domain.model.Cliente;
import store.ojuara.pedidoapi.mapper.ClienteMapper;
import store.ojuara.pedidoapi.repository.ClienteRepository;
import store.ojuara.pedidoapi.repository.specification.ClienteSpecification;
import store.ojuara.pedidoapi.service.validator.ClienteValidator;
import store.ojuara.pedidoapi.shared.utils.StringUtils;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteValidator validator;
    private final ClienteRepository repository;
    private final ClienteMapper mapper;
    private final ClienteSpecification specification;

    @Override
    public ClienteDTO visualizar(Long id) {
        return mapper.toDto(validator.verificarExistencia(id));
    }

    @Override
    public ClienteDTO visualizarPorUuid(UUID uuid) {
        return mapper.toDto(validator.verificarExistencia(uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteDTO> listar(Pageable paginacao) {
        var pageCamisa = repository.findAll(paginacao);
        return pageCamisa.map(this::toDTO);
    }

    @Override
    public ClienteDTO cadastrar(ClienteForm form) {
        String cpfCnpjFormatado = StringUtils.removerCaracteresEspeciais(form.getCpfCnpj());
        form.setCpfCnpj(cpfCnpjFormatado);
        var cliente = mapper.toModel(form);
        cliente.setSituacao(Situacao.CADASTRADO);

        return mapper.toDto(repository.save(cliente));
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteUpdateForm updateForm) {
        var cliente = validator.verificarExistencia(id);
        mapper.updateClienteFromClienteUpdateForm(updateForm, cliente);

        return mapper.toDto(repository.save(cliente));
    }

    @Override
    public void excluir(Long id) {
        var cliente = validator.verificarExistencia(id);
        repository.delete(cliente);
    }

    @Override
    public Page<ClienteDTO> pesquisarComFiltrosSpecification(UUID accountId, String nome, String accountEmail,
                                                             String accountPhone, LocalDate dataNascimento, Genero genero,
                                                             String cpfCnpj, Situacao situacao, Pageable paginacao) {

        Specification<Cliente> spec = specification.filtrar(accountId, nome, accountEmail, accountPhone,
                dataNascimento, genero, cpfCnpj, situacao);
        Page<Cliente> pageCamisa = repository.findAll(spec, paginacao);

        return pageCamisa.map(this::toDTO);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return mapper.toDto(cliente);
    }
}

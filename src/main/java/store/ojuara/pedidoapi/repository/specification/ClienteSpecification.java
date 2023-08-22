package store.ojuara.pedidoapi.repository.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import store.ojuara.pedidoapi.domain.enums.GeneroEnum;
import store.ojuara.pedidoapi.domain.enums.SituacaoEnum;
import store.ojuara.pedidoapi.domain.model.Cliente;
import store.ojuara.pedidoapi.shared.utils.StringUtils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClienteSpecification {

    public Specification<Cliente> filtrar(UUID accountId, String nome, String accountEmail,
                                          String accountPhone, LocalDate dataNascimento,
                                          GeneroEnum genero, String cpfCnpj, SituacaoEnum situacao) {

        Specification<Cliente> spec = null;
        Specification<Cliente> temp = null;

        if(Objects.nonNull(accountId)){
            temp = filterByAccountId(accountId);
            spec = temp;
        }
        if(Objects.nonNull(nome)){
            temp = filterByNome(nome);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(accountEmail)){
            temp = filterByAccountEmail(accountEmail);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(accountPhone)){
            temp = filterByAccountPhone(accountPhone);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(dataNascimento)){
            temp = filterByDataNascimento(dataNascimento);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(genero)){
            temp = filterByGenero(genero);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(cpfCnpj)){
            temp = filterByCpfCnpj(cpfCnpj);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }
        if(Objects.nonNull(situacao)){
            temp = filterBySituacao(situacao);
            spec = spec != null ? Specification.where(spec).and(temp) : temp;
        }

        return spec;
    }

    public Specification<Cliente> filterByAccountId(UUID accountId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("accountId"), accountId);
    }

    public Specification<Cliente> filterByNome(String nome) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public Specification<Cliente> filterByAccountEmail(String accountEmail) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("accountEmail")), "%" + accountEmail.toLowerCase() + "%");
    }

    public Specification<Cliente> filterByAccountPhone(String accountPhone) {
        String phoneSemMascara = StringUtils.removerCaracteresEspeciais(accountPhone);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("accountPhone"), "%" + phoneSemMascara + "%");
    }

    public Specification<Cliente> filterByDataNascimento(LocalDate dataNascimento) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("dataNascimento"), dataNascimento);
    }

    public Specification<Cliente> filterByGenero(GeneroEnum genero) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("genero"), genero);
    }

    public Specification<Cliente> filterByCpfCnpj(String cpfCnpj) {
        String cpfCnpjFormatado = StringUtils.removerCaracteresEspeciais(cpfCnpj);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("cpfCnpj"), "%" + cpfCnpjFormatado + "%");
    }

    public Specification<Cliente> filterBySituacao(SituacaoEnum situacao) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("situacao"), "%" + situacao + "%");
    }
}

package store.ojuara.pedidoapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situacao {

    ATIVO("Ativo"),
    CADASTRADO("Cadastrado"),
    INATIVO("Inativo"),
    CANCELADO("Cancelado");

    private final String descricao;
}

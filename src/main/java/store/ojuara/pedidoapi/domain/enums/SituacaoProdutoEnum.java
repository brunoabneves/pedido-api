package store.ojuara.pedidoapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SituacaoProdutoEnum {

    ATIVO("Ativo"),
    CADASTRADO("Cadastrado"),
    INATIVO("Inativo"),
    CANCELADO("Cancelado"),
    SEM_ESTOQUE("Sem estoque");

    private final String descricao;
}

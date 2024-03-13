package store.ojuara.pedidoapi.client.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SituacaoProduto {

    ATIVO("Ativo"),
    CADASTRADO("Cadastrado"),
    INATIVO("Inativo"),
    CANCELADO("Cancelado"),
    SEM_ESTOQUE("Sem estoque");

    private final String descricao;
}

package store.ojuara.pedidoapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedidoEnum {

    CANCELADO("Cancelado"),
    EM_PROCESSAMENTO("Em processamento"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    RECEBIDO("Recebido");

    private final String descricao;
}

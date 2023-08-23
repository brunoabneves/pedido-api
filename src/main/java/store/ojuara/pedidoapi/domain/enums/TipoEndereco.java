package store.ojuara.pedidoapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoEndereco {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial");

    private final String descricao;
}

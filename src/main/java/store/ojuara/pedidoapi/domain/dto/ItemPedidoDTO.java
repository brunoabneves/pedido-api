package store.ojuara.pedidoapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long idPedido;
    private UUID uuidProduto;
    private int quantidade;
    private BigDecimal subtotal;
}

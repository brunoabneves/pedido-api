package store.ojuara.pedidoapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.MetodoPagamento;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private UUID uuid;
    private StatusPedido status;
    private BigDecimal valorTotal;
    private MetodoPagamento metodoPagamento;
    private String observacoesCliente;
    private UUID clienteUuid;
    private List<ItemPedidoDTO> itens = new ArrayList<>();
}

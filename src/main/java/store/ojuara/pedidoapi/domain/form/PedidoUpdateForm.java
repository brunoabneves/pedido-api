package store.ojuara.pedidoapi.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.MetodoPagamento;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoUpdateForm {

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;
    private String observacoesCliente;
    private Long clienteId;
    private List<Long> produtosIds;
}

package store.ojuara.pedidoapi.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.MetodoPagamento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoForm {

    @NotNull(message = "Campo obrigatório.")
    private MetodoPagamento metodoPagamento;
    private String observacoesCliente;
    private Long clienteId;
}

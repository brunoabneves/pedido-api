package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.MetodoPagamento;
import store.ojuara.pedidoapi.domain.enums.StatusPedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido extends ModeloGenerico{

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    private String observacoesCliente;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ElementCollection
    @CollectionTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "produto_api_id")
    private List<UUID> idsProdutos = new ArrayList<>();
}

package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.MetodoPagamentoEnum;
import store.ojuara.pedidoapi.domain.enums.StatusPedidoEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido extends ModeloGenerico{

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPagamentoEnum metodoPagamento;

    private String observacoesCliente;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos = new ArrayList<>();
}

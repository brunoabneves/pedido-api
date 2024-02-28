package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido  extends ModeloGenerico {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private UUID uuidProdutoExterno;
    private int quantidade;
    private BigDecimal subtotal;
}
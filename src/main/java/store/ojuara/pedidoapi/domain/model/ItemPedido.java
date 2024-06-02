package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido  extends ModeloGenerico {
    private UUID uuidProduto;
    private int quantidade;
    private BigDecimal subtotal;
}
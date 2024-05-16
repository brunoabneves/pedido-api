package store.ojuara.pedidoapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.avro.pedidorealizado.ItemPedidoAvro;

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

    public ItemPedidoAvro toAvro(ItemPedidoDTO dto) {
        ItemPedidoAvro itemPedidoAvro = ItemPedidoAvro.newBuilder().build();
        itemPedidoAvro.setIdPedido((dto.getIdPedido().intValue()));
        itemPedidoAvro.setUuidProduto(dto.getUuidProduto().toString());
        itemPedidoAvro.setQuantidade(dto.getQuantidade());
        itemPedidoAvro.setSubtotal(dto.getSubtotal().toString());
        return itemPedidoAvro;
    }
}

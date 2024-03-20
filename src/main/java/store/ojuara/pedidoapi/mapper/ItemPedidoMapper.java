package store.ojuara.pedidoapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;
import store.ojuara.pedidoapi.domain.form.ItemPedidoForm;
import store.ojuara.pedidoapi.domain.model.ItemPedido;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper extends EntityMapper<ItemPedidoDTO, ItemPedido, ItemPedidoForm>{

    @Mappings({
            @Mapping(target = "idPedido", source = "pedido.id"),
            @Mapping(target = "uuidProduto", source = "uuidProduto")
    })
    ItemPedidoDTO toDto(ItemPedido entity);
}

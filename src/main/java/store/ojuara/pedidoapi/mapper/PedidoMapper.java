package store.ojuara.pedidoapi.mapper;

import org.mapstruct.*;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.domain.form.PedidoUpdateForm;
import store.ojuara.pedidoapi.domain.model.Pedido;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido, PedidoForm> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePedidoFromPedidoUpdateForm(PedidoUpdateForm pedidoUpdateForm, @MappingTarget Pedido pedido);
    PedidoForm toForm(Pedido entity);
    Pedido toModel(PedidoForm form);
    List<Pedido> toModel(List<PedidoForm> formList);
    List<Pedido> toModel(Set<PedidoForm> formSet);

    @Mappings({
            @Mapping(target = "clienteUuid", source = "cliente.uuid")
    })
    List<PedidoDTO> toDto(List<Pedido> entityList);
}

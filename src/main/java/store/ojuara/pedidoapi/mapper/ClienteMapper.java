package store.ojuara.pedidoapi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import store.ojuara.pedidoapi.domain.dto.ClienteDTO;
import store.ojuara.pedidoapi.domain.form.ClienteForm;
import store.ojuara.pedidoapi.domain.form.ClienteUpdateForm;
import store.ojuara.pedidoapi.domain.model.Cliente;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente, ClienteForm>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClienteFromClienteUpdateForm(ClienteUpdateForm clienteUpdateForm, @MappingTarget Cliente cliente);
    ClienteForm toForm(Cliente entity);
    Cliente toModel(ClienteForm form);
    List<Cliente> toModel(List<ClienteForm> formList);
    List<Cliente> toModel(Set<ClienteForm> formSet);
    List<ClienteDTO> toDto(List<Cliente> entityList);
}

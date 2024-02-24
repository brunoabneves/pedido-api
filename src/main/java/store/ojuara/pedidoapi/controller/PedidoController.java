package store.ojuara.pedidoapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.ojuara.pedidoapi.domain.dto.PedidoDTO;
import store.ojuara.pedidoapi.domain.form.PedidoForm;
import store.ojuara.pedidoapi.service.pedido.PedidoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoController {

    private PedidoService service;
    @Operation(summary = "Cadastrar pedido.")
    @PostMapping("/cadastrar")
    public ResponseEntity<PedidoDTO> cadastrar(@Valid @RequestBody PedidoForm form, @RequestParam List<UUID> idsProdutos, UriComponentsBuilder uriBuilder) {

        var dto = service.cadastrar(form, idsProdutos);
        URI uri = uriBuilder.path("/camisas/{uuid}").buildAndExpand(dto.getUuid()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}

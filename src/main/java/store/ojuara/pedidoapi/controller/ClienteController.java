package store.ojuara.pedidoapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.ojuara.pedidoapi.domain.dto.ClienteDTO;
import store.ojuara.pedidoapi.domain.enums.Genero;
import store.ojuara.pedidoapi.domain.enums.Situacao;
import store.ojuara.pedidoapi.domain.form.ClienteForm;
import store.ojuara.pedidoapi.domain.form.ClienteUpdateForm;
import store.ojuara.pedidoapi.service.cliente.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService service;

    @Operation(summary = "Visualizar um cliente.", description = "Busca um cliente pelo seu UUID.")
    @GetMapping("/{uuid}")
    public ResponseEntity<ClienteDTO> visualizar(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.visualizarPorUuid(uuid));
    }

    @Operation(summary = "Lista todos os clientes.", description = "Retorna uma lista paginada com todos os clientes.")
    @GetMapping("/listar-todos")
    public ResponseEntity<Page<ClienteDTO>> listarTodos(
            @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @Operation(summary = "Filtrar clientes.", description = "Retorna uma lista de clientes de acordo com os filtros especificados.")
    @GetMapping("/buscar")
    public ResponseEntity<Page<ClienteDTO>> buscarComFiltros(
            @RequestParam(value = "accountId", required = false) UUID accountId,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "accountEmail", required = false) String accountEmail,
            @RequestParam(value = "accountPhone", required = false) String accountPhone,
            @RequestParam(value = "dataNascimento", required = false) LocalDate dataNascimento,
            @RequestParam(value = "genero", required = false) Genero genero,
            @RequestParam(value = "cpfCnpj", required = false) String cpfCnpj,
            @RequestParam(value = "situacao", required = false) Situacao situacao,
            @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {

        return ResponseEntity.ok(service.pesquisarComFiltrosSpecification(accountId, nome, accountEmail, accountPhone,
                dataNascimento, genero, cpfCnpj, situacao, paginacao));
    }

    @Operation(summary = "Cadastrar cliente.")
    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrar(@Valid @RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {

        var dto = service.cadastrar(form);
        URI uri = uriBuilder.path("/clientes/{uuid}").buildAndExpand(dto.getUuid()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(summary = "Atualizar cliente por ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteUpdateForm form) {
        return ResponseEntity.ok(service.atualizar(id, form));
    }

    @Operation(summary = "Excluir cliente por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

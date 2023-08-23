package store.ojuara.pedidoapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.Genero;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private UUID uuid;
    private UUID accountId;
    private String nome;
    private String accountEmail;
    private String telefone;
    private LocalDate dataNascimento;
    private Genero genero;
    private String cpfCnpj;
}

package store.ojuara.pedidoapi.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.Genero;
import store.ojuara.pedidoapi.domain.validations.CpfCnpjValid;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    @NotNull(message = "Este é um campo obrigatório.")
    private String nome;

    @NotNull(message = "Este é um campo obrigatório.")
    private LocalDate dataNascimento;

    private Genero genero;

    @NotNull(message = "Este é um campo obrigatório.")
    @CpfCnpjValid(message = "cpf ou cnpj inválido.")
    private String cpfCnpj;
}

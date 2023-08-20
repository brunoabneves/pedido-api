package store.ojuara.pedidoapi.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.ojuara.pedidoapi.domain.enums.GeneroEnum;
import store.ojuara.pedidoapi.domain.validations.CpfCnpjValid;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateForm {

    private String nome;
    private LocalDate dataNascimento;
    private GeneroEnum genero;
    @CpfCnpjValid(message = "cpf ou cnpj inválido.")
    private String cpfCnpj;
}

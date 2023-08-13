package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.TipoEnderecoEnum;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends ModeloGenerico{

    @Enumerated(EnumType.STRING)
    private TipoEnderecoEnum tipoEndereco;
    private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

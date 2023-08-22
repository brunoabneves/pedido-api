package store.ojuara.pedidoapi.domain.form;

import store.ojuara.pedidoapi.domain.enums.TipoEnderecoEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EnderecoForm {

    @Enumerated(EnumType.STRING)
    private TipoEnderecoEnum tipoEndereco;
    private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
}

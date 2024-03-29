package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.Genero;
import store.ojuara.pedidoapi.domain.enums.Situacao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends ModeloGenerico {

    @Column(unique = true)
    private UUID accountId;
    private String nome;
    @Column(unique = true)
    private String accountEmail;
    private String accountPhone;
    private LocalDate dataNascimento;
    private Genero genero;
    @Column(unique = true)
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ElementCollection
    @CollectionTable(name = "cliente_lista_desejos",
            joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "produto_api_id")
    private List<Long> listaDeDesejos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "cliente_carrinho_compras",
            joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "produto_api_id")
    private List<Long> carrinhoDeCompras = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_residencial_id")
    private Endereco enderecoResidencial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Endereco> enderecosDeEntrega = new ArrayList<>();
}

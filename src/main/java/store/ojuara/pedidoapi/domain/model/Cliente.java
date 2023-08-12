package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.GeneroEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends ModeloGenerico {

    private String nome;
    private String email;
    private String senha; //TODO este atributo ficará aqui?
    private String telefone;
    private LocalDate dataNascimento;
    private GeneroEnum genero;
    private String cpfCnpj;

    @ManyToMany
    @JoinTable(name = "cliente_lista_desejos",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> listaDeDesejos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cliente_carrinho_compras",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> carrinhoDeCompras = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();
}

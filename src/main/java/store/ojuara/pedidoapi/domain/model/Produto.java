package store.ojuara.pedidoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.ojuara.pedidoapi.domain.enums.SituacaoProdutoEnum;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends ModeloGenerico{

    private String nome;
    private String descricao;
    private String marca;
    private BigDecimal precoVenda;
    private Integer quantidade;
    private String cor;
    private String material;
    private String imagemUrl;
    private UUID uuidProdutoApi;
    private SituacaoProdutoEnum situacao;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos = new ArrayList<>();
}

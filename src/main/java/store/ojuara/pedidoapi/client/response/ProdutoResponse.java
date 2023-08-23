package store.ojuara.pedidoapi.client.response;

import lombok.Data;
import store.ojuara.pedidoapi.client.enums.SituacaoProduto;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoResponse {

    private String nome;
    private String descricao;
    private String marca;
    private BigDecimal precoVenda;
    private Integer quantidade;
    private String cor;
    private String material;
    private String imagemUrl;
    private UUID uuidProdutoApi;
    private SituacaoProduto situacao;
}

package store.ojuara.pedidoapi.client.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoResponse {

    private Long id;
    private UUID uuid;
    private String nome;
    private String descricao;
    private String marca;
    private String fornecedor;
    private BigDecimal precoFornecedor;
    private BigDecimal precoVenda;
    private Integer quantidade;
    private String cor;
    private String imagemUrl;
    private String categoria;
    private String setor;
    private String genero;
    private String situacaoProdutoEnum;
    private String modalidade;
    private Integer pontuacao;
    private String tipo;
    private String material;
    private String solado;
    private String cabedal;
    private String peso;
    private String medida;
    private String tamanhoCamisa;
    private Integer alturaEmCm;
    private Integer larguraEmCm;
    private boolean isCamisaDeTime;
    private boolean permitePersonalizacao;
    private String time;
    private String tipoGola;
    private String tipoManga;
}

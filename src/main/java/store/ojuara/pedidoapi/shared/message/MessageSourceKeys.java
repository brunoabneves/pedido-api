package store.ojuara.pedidoapi.shared.message;

public class MessageSourceKeys {

    // Validacões Padrão
    public static final String ARGUMENTO_INVALIDO = "{key.argumento.invalido}";

    // Exceções de HTTP
    public static final String REQUEST_METHOD = "{key.invalid.method.request}";
    public static final String MESSAGE_NOT_READABLE = "{key.message.not.readable}";
    public static final String ILLEGAL_ARGUMENT = "{key.illegal.argumentes}";
    public static final String NULL_POINTER = "{key.null.pointer}";
    public static final String REGISTRO_DUPLICADO = "{key.registro.duplicado}";

    // Exceções de Feign
    public static final String SERVICE_UNAVAILABLE = "{key.service.unavailable}";
    public static final String SERVICE_ERRO = "{key.service.erro}";
    public static final String ENTITY_NOT_FOUND = "{key.entity.not.found}";

    public static final String MENSAGEM_INVALIDA = "{key.mensagem.invalida}";
    public static final String DATAS_INICIO_FIM_INCORRETO = "{key.data.inicio-fim.incorreto}";

    // Produto
    public static final String PRODUTO_INEXISTENTE = "{key.chuteira.inexistente-ou-inativo}";
    public static final String PRODUTO_INVALIDO = "{key.chuteira.invalido}";
}

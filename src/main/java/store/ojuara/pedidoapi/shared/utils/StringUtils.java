package store.ojuara.pedidoapi.shared.utils;

public class StringUtils {

    public static String removerCaracteresEspeciais(String palavra) {
        return palavra.replaceAll("[^a-zA-Z]", "");
    }
}

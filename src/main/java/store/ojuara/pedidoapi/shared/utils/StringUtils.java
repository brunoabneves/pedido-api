package store.ojuara.pedidoapi.shared.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String removerCaracteresEspeciais(String palavra) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(palavra);
        return matcher.replaceAll("");
    }
}

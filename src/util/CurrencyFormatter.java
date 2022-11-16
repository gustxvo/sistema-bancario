package util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static String getRealFormatado(double valor) {
        Locale locale = new Locale( "pt", "BR" );
        NumberFormat numberFormatToReal = NumberFormat.getCurrencyInstance(locale);
        return numberFormatToReal.format(valor);
    }

    public static void printValorImposto(String mensagem, double valor) {
        System.out.println(mensagem + ": " + getRealFormatado(valor) + "\n");
    }
}
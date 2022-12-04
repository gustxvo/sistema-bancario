package tax;

public class CalculadorImposto implements Tributavel {

    private static double impostoTotal;

    public static void calcularImposto(double valor) {
        impostoTotal += valor;
    }

    @Override
    public double getValorImposto() {
        return impostoTotal;
    }
}

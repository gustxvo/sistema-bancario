package tax;

public class CalculadorImposto implements Tributavel {

    private static double impostoTotal;

    public static void adicionarImposto(double valor) {
        impostoTotal += valor;
    }

    public static void recalcularImposto(double impostoAntigo, double novoImposto) {
        impostoTotal -= impostoAntigo;
        adicionarImposto(novoImposto);
    }

    @Override
    public double getValorImposto() {
        return impostoTotal;
    }
}

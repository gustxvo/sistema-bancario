package tax;

public class CalculadorImposto implements Tributavel {

    private static double totalImpostos;

    public static void adicionarImposto(double valor) {
        totalImpostos += valor;
    }

    @Override
    public double getValorImposto() {
        return totalImpostos;
    }
}

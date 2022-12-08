package tax;

public class CalculadorImposto {

    private double impostoTotal;

    public void calcular(Tributavel valor) {
        impostoTotal += valor.getValorImposto();
    }

    public double getImpostoTotal() {
        return impostoTotal;
    }
}

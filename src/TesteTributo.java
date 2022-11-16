import model.ContaCorrente;
import model.SeguroDeVida;
import tax.CalculadorImposto;
import util.CurrencyFormatter;

public class TesteTributo {

    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(132, 32132);
        contaCorrente.setNomeTitular("Cadu Pascoal");
        contaCorrente.depositar(345.00);
        contaCorrente.consultar();
        System.out.println();

        CalculadorImposto calculadorImposto = new CalculadorImposto();
        printImpostoTotal(calculadorImposto.getValorImposto());

        SeguroDeVida seguroDeVida = new SeguroDeVida();
        CurrencyFormatter.printValorImposto("Imposto do Seguro", seguroDeVida.getValorImposto());

        // Recalculando valor do imposto total
        printImpostoTotal(calculadorImposto.getValorImposto());
    }

    // Imprime na tela o valor do imposto formatado na moeda Real
    public static void printImpostoTotal(double impostoTotal) {
        CurrencyFormatter.printValorImposto("Imposto total", impostoTotal);
    }
}

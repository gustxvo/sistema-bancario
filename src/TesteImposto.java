import model.ContaCorrente;
import model.SeguroDeVida;
import tax.CalculadorImposto;
import util.CurrencyFormatter;

public class TesteImposto {

    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente(132, 32132);
        contaCorrente.setNomeTitular("Cadu Pascoal");
        contaCorrente.depositar(100);
        contaCorrente.consultar();

        contaCorrente.sacar(100);
        System.out.println();

        contaCorrente.consultar();

        SeguroDeVida seguroDeVida = new SeguroDeVida();
        CurrencyFormatter.printValor("Imposto do Seguro", seguroDeVida.getValorImposto());
        System.out.println();

        CalculadorImposto calculadorImposto = new CalculadorImposto();
        printImpostoTotal(calculadorImposto.getValorImposto());

        ContaCorrente cc = new ContaCorrente(155, 5425);
        cc.setNomeTitular("Bruna Laynes");

        contaCorrente.transferir(cc, 100);
        contaCorrente.consultar();

        cc.consultar();

        // Recalculando valor do imposto total
        System.out.println("Recalculando imposto total");
        // Esperado: 5,00 + 42,00 + 4,05 = 51,05
        printImpostoTotal(calculadorImposto.getValorImposto());
    }

    // Imprime na tela o valor do imposto formatado na moeda Real
    public static void printImpostoTotal(double impostoTotal) {
        CurrencyFormatter.printValor("Imposto total", impostoTotal);
        System.out.println();
    }
}

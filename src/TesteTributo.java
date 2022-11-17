import model.ContaCorrente;
import model.ContaPoupanca;
import model.SeguroDeVida;
import tax.CalculadorImposto;
import util.CurrencyFormatter;

public class TesteTributo {

    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(132, 32132);
        contaCorrente.setNomeTitular("Cadu Pascoal");
        contaCorrente.depositar(345.00);
        contaCorrente.consultar();

        SeguroDeVida seguroDeVida = new SeguroDeVida();
        CurrencyFormatter.printValorImposto("Imposto do Seguro", seguroDeVida.getValorImposto());

        CalculadorImposto calculadorImposto = new CalculadorImposto();
        printImpostoTotal(calculadorImposto.getValorImposto());

        // Não deve possuir imposto
        ContaPoupanca contaPoupanca = new ContaPoupanca(214, 4235);
        contaPoupanca.setNomeTitular("Bruno Sangregório");
        contaPoupanca.depositar(1000);
        contaPoupanca.consultar();
        System.out.println();

        ContaCorrente cc = new ContaCorrente(155, 5425);
        cc.setNomeTitular("Bruna Laynes");
        contaCorrente.transferir(cc, 150);
        cc.consultar();

        // Novo tributo do objeto contaCorrente
        contaCorrente.sacar(80);
        contaCorrente.consultar();

        // Recalculando valor do imposto total
        System.out.println("Recalculando imposto total");
        // Esperado: 42,00 + 1,50 + 1,15 = 44,65
        printImpostoTotal(calculadorImposto.getValorImposto());
    }

    // Imprime na tela o valor do imposto formatado na moeda Real
    public static void printImpostoTotal(double impostoTotal) {
        CurrencyFormatter.printValorImposto("Imposto total", impostoTotal);
    }
}

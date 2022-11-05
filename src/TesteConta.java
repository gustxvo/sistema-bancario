import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import util.CurrencyFormatter;

public class TesteConta {

    public static void main(String[] args) {
        Conta contaPoupanca = new ContaPoupanca(1235, 412004);
        contaPoupanca.setNomeTitular("Horácio");
        contaPoupanca.depositar(100.0);
        contaPoupanca.consultar();
        contaPoupanca.sacar(123.0);
        System.out.println();

        Conta contaCorrente = new ContaCorrente(1234, 237890);
        contaCorrente.setNomeTitular("Roberta");
        contaCorrente.depositar(800.0);
        contaCorrente.consultar();
        contaCorrente.sacar(130.0);
        contaCorrente.transferir(contaPoupanca, 150.0);

        System.out.println("Saldo: " +
                CurrencyFormatter.getRealFormatado(contaCorrente.getSaldo()));
        System.out.println();

        // Consultando saldo conta do crediário após transferência
        System.out.printf("Crediário: %s\nSaldo: %s\n",
                contaPoupanca.getNomeTitular(),
                contaPoupanca.getSaldo());
        System.out.println();

        Conta conta3 = new ContaPoupanca(1235, 608088);
        conta3.setNomeTitular("Conta 3");
        conta3.depositar(5000);
        conta3.consultar();
        System.out.println();

        System.out.printf("Quantidade de contas: %d", Conta.getQuantidadeContas());
    }
}
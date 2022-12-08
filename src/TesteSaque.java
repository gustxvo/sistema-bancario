import exception.LimiteSaqueException;
import exception.MultiploNotaException;
import exception.SaldoInsuficienteException;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import util.CurrencyFormatter;

public class TesteSaque {

    public static void main(String[] args) throws SaldoInsuficienteException, MultiploNotaException, LimiteSaqueException {

        double valorSaque = 100.0;

        Conta contaCorrente = new ContaCorrente(1234, 237890);
        contaCorrente.setNomeTitular("Beatriz");
        contaCorrente.depositar(500.0);
        contaCorrente.consultar();

        contaCorrente.sacar(valorSaque);
        System.out.printf("Sacando %.2f...", valorSaque);
        System.out.printf("\nSaldo: %s", CurrencyFormatter
                .getRealFormatado(contaCorrente.getSaldo()));
        System.out.println("\n");

        // Teste para garantir que taxa seja aplicada apenas à conta poupança
        Conta contaPoupanca = new ContaPoupanca(32324, 45203);
        contaPoupanca.setNomeTitular("Arthur");
        contaPoupanca.depositar(500.0);
        contaPoupanca.consultar();

        contaPoupanca.sacar(valorSaque);
        System.out.printf("Sacando %.2f...", valorSaque);
        System.out.printf("\nSaldo: %s", CurrencyFormatter
                .getRealFormatado(contaPoupanca.getSaldo()));
    }
}
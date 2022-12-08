import exception.LimiteSaqueException;
import exception.MultiploNotaException;
import exception.SaldoInsuficienteException;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class TesteConta {

    public static void main(String[] args) {
        Conta contaPoupanca = new ContaPoupanca(32324, 45203);
        contaPoupanca.setNomeTitular("Arthur");
        contaPoupanca.depositar(400.0);
        contaPoupanca.consultar();

        try {
            contaPoupanca.sacar(20);
        } catch (SaldoInsuficienteException | LimiteSaqueException | MultiploNotaException ex) {
            System.out.println(ex.getMessage());
        } finally { System.out.println(); }

        try {
            contaPoupanca.sacar(350);
        } catch (SaldoInsuficienteException | LimiteSaqueException | MultiploNotaException ex) {
            System.out.println(ex.getMessage());
        } finally { System.out.println(); }

        try {
            contaPoupanca.sacar(250);
            contaPoupanca.consultar();
        } catch (SaldoInsuficienteException | LimiteSaqueException | MultiploNotaException ex) {
            System.out.println(ex.getMessage());
        } finally { contaPoupanca.consultar(); }

        try {
            contaPoupanca.sacar(250);
        } catch (SaldoInsuficienteException | LimiteSaqueException | MultiploNotaException ex) {
            System.out.println(ex.getMessage());
        } finally { System.out.println(); }

        Conta contaCorrente = new ContaCorrente(1234, 237890);
        contaCorrente.setNomeTitular("Beatriz");
        contaCorrente.depositar(500.0);
        contaCorrente.consultar();

        try {
            contaCorrente.sacar(500);
        } catch (SaldoInsuficienteException | LimiteSaqueException | MultiploNotaException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
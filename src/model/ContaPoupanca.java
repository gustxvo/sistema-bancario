package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroAgencia, int numeroConta) {
        super(numeroAgencia, numeroConta);
        super.setTipoConta("Conta Poupança");
    }
}
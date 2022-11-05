package model;

import util.CurrencyFormatter;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroAgencia, int numeroConta) {
        super(numeroAgencia, numeroConta);
        super.setTipoConta("Conta Poupança");
    }

    @Override
    public void sacar(double valor) {

        if (saldo > valor) {
            this.saldo -= valor;
        } else {
            System.out.println("\u001b[31;1m" +
                    "Saldo insuficiente\u001b[m");

            System.out.println("Saldo: " +
                    CurrencyFormatter.getRealFormatado(saldo));
        }
    }
}
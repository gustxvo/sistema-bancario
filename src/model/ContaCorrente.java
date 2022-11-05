package model;

import util.CurrencyFormatter;

public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE_CONTA_CORRENTE = 0.2;

    public ContaCorrente(int numeroAgencia, int numeroConta) {
        super(numeroAgencia, numeroConta);
        super.setTipoConta("Conta Corrente");
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE_CONTA_CORRENTE;

        if (this.saldo < valorComTaxa) {
            System.out.println("\u001b[31;1m" +
                    "Saldo insuficiente\u001b[m");

            System.out.println("Saldo: " +
                    CurrencyFormatter.getRealFormatado(saldo));
        } else {
            this.saldo -= valorComTaxa;
        }
    }
}
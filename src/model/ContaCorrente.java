package model;

import tax.CalculadorImposto;
import tax.Tributavel;
import util.CurrencyFormatter;

public class ContaCorrente extends Conta implements Tributavel {

    private static final double TAXA_SAQUE_CONTA_CORRENTE = 0.2;
    private static final double TAXA_IMPOSTO = 0.01;

    public ContaCorrente(int numeroAgencia, int numeroConta) {
        super(numeroAgencia, numeroConta);
        super.setTipoConta("Conta Corrente");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE_CONTA_CORRENTE;
        super.sacar(valorComTaxa);
        CurrencyFormatter.printValor("Imposto", getValorImposto());
    }

    @Override
    public double getValorImposto() {
        return this.saldo * TAXA_IMPOSTO;
    }

}
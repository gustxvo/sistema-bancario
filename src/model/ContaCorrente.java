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
    public void sacar(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE_CONTA_CORRENTE;

        if (this.saldo < valorComTaxa) {
            System.out.println("\u001b[31;1m" +
                    "Saldo insuficiente\u001b[m");

            System.out.println("Saldo: " +
                    CurrencyFormatter.getRealFormatado(saldo));
        } else {
            CurrencyFormatter.printValor("Valor do imposto", getValorImposto());
            CalculadorImposto.calcularImposto(getValorImposto());
            this.saldo -= valorComTaxa - getValorImposto();
        }
    }

    @Override
    public double getValorImposto() {
        return this.saldo * TAXA_IMPOSTO;
    }
}
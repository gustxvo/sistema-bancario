package model;

import exception.LimiteSaqueException;
import exception.MultiploNotaException;
import exception.TaxaNaoTributadaException;
import exception.SaldoInsuficienteException;
import tax.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {

    public static final double TAXA_SAQUE_CONTA_CORRENTE = 0.2;
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
    public void sacar(double valor) throws SaldoInsuficienteException,
            MultiploNotaException, LimiteSaqueException {
        double valorComTaxa = valor + TAXA_SAQUE_CONTA_CORRENTE;
        if (this.saldo == valor) {
            throw new TaxaNaoTributadaException(this.saldo, valorComTaxa);
        }
        super.sacar(valorComTaxa);
    }

    @Override
    public double getValorImposto() {
        return this.saldo * TAXA_IMPOSTO;
    }

}
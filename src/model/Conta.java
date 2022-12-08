package model;

import exception.LimiteSaqueException;
import exception.MultiploNotaException;
import exception.SaldoInsuficienteException;
import util.CurrencyFormatter;

public abstract class Conta {

    private int numeroAgencia;
    private int numeroConta;
    private String tipoConta;
    protected double saldo;
    private String nomeTitular;
    private static int quantidadeContas;

    public Conta(int numeroAgencia, int numeroConta) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        Conta.quantidadeContas++;
    }

    public abstract void depositar(double valor);

    public void sacar(double valor) throws
            SaldoInsuficienteException, MultiploNotaException, LimiteSaqueException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException(this.saldo, valor);
        }
        if (valor > 300) {
            throw new LimiteSaqueException("Limite de saque excedido");
        }
        if (valor % 20 == 0) {
            throw new MultiploNotaException("Valor do saque não pode ser composto por cédulas de R$20");
        } else {
            this.saldo -= valor;
            System.out.println("Saque efetuado com sucesso");
        }
    }

    public void transferir(Conta contaDestino, double valorTransferencia) throws
            SaldoInsuficienteException, MultiploNotaException, LimiteSaqueException {
        this.sacar(valorTransferencia);

        contaDestino.depositar(valorTransferencia);
        System.out.printf("Transferindo %s para %s...\n\n",
                CurrencyFormatter.getRealFormatado(valorTransferencia),
                contaDestino.getNomeTitular());
    }

    public void consultar() {
        System.out.println("Nome do titular: " + nomeTitular);
        System.out.println("Tipo de Conta: " + tipoConta);
        System.out.println("Saldo da conta: " + CurrencyFormatter.getRealFormatado(saldo));
        System.out.println();
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
}
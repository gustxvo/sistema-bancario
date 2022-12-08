package model;

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

    public void sacar(double valor) {
        if (saldo > valor) {
            this.saldo -= valor;
            System.out.println("Operação realizada com sucesso");
        } else {
            System.out.println("\u001b[31;1m" +
                    "Saldo insuficiente\u001b[m");

            System.out.println("Saldo: " +
                    CurrencyFormatter.getRealFormatado(saldo));
        }
    }

    public void transferir(Conta contaDestino, double valorTransferencia) {
        this.sacar(valorTransferencia);

        contaDestino.depositar(valorTransferencia);
        System.out.printf("Transferindo %s para %s...\n\n",
                CurrencyFormatter.getRealFormatado(valorTransferencia),
                contaDestino.getNomeTitular());
    }

    public void consultar() {
        System.out.println("Nome do titular: " + nomeTitular);
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
package exception;

import util.CurrencyFormatter;

public class SaldoInsuficienteException extends Exception {

    protected double saldo;
    protected double valor;

    public SaldoInsuficienteException(double saldo, double valor) {
        this.saldo = saldo;
        this.valor = valor;
    }

    @Override
    public String getMessage() {
        return "Saldo insuficiente" +
                "\nSaldo: " + CurrencyFormatter.getRealFormatado(saldo) +
                "\nValor: " + CurrencyFormatter.getRealFormatado(valor);
    }
}

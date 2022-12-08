package exception;

import util.CurrencyFormatter;

import static model.ContaCorrente.TAXA_SAQUE_CONTA_CORRENTE;

public class TaxaNaoTributadaException extends SaldoInsuficienteException {

    public TaxaNaoTributadaException(double saldo, double valorComTaxa) {
        super(saldo, valorComTaxa - TAXA_SAQUE_CONTA_CORRENTE);
    }

    @Override
    public String getMessage() {
        return super.getMessage() +
                "\nTaxa: " + CurrencyFormatter.getRealFormatado(TAXA_SAQUE_CONTA_CORRENTE);
    }
}

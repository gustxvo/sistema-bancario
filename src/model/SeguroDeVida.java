package model;

import tax.CalculadorImposto;
import tax.Tributavel;

public class SeguroDeVida implements Tributavel {

    private static final double IMPOSTO_SEGURO_DE_VIDA = 42.0;

    public SeguroDeVida() {
        CalculadorImposto.calcularImposto(IMPOSTO_SEGURO_DE_VIDA);
    }

    @Override
    public double getValorImposto() {
        return IMPOSTO_SEGURO_DE_VIDA;
    }
}

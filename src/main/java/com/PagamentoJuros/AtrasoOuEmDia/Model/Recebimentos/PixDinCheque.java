package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class PixDinCheque implements Recebimentos{
    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculoFinal(BigDecimal valor, BigDecimal desconto) {
        return BigDecimal.ZERO;
    }
}

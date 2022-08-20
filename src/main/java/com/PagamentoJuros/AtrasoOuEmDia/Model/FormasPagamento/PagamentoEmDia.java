package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoEmDia implements Pagamentos {

    @Override
    public BigDecimal calculoPagamento(BigDecimal valorAPagar, BigDecimal diferenca) {
        BigDecimal resultadoPagamentoEmDia = valorAPagar.subtract(diferenca);
        return resultadoPagamentoEmDia;
    }
}

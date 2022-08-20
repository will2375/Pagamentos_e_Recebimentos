package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoAtrasado implements Pagamentos {

    @Override
    public BigDecimal calculoPagamento(BigDecimal valorAPagar, BigDecimal diferenca) {
        BigDecimal resultadoAtraso = valorAPagar.add(diferenca);
        return resultadoAtraso;
    }
}
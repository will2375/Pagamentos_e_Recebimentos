package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoAtrasado implements Pagamentos {


    @Override
    public BigDecimal calculoPagamento(BigDecimal valor, BigDecimal diferencial) {
        BigDecimal resultadoAtraso = valor.add(diferencial);
        return resultadoAtraso;
    }
}
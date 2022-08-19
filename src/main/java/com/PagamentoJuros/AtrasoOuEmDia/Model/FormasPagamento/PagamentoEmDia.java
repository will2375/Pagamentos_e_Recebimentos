package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoEmDia implements Pagamentos {

    @Override
    public BigDecimal calculoPagamento(BigDecimal valor, BigDecimal diferencial) {
        BigDecimal resultado = valor.subtract(diferencial);
        return resultado;
    }
}

package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoEmDia {

    public BigDecimal PagamentoDia(BigDecimal valor, BigDecimal desconto){
        BigDecimal resultado = valor.subtract(desconto);
        return resultado;
    }
}

package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public class PagamentoAtrasado {

    public BigDecimal PagamentoAtraso(BigDecimal valor, BigDecimal juros){
        BigDecimal resultadoAtraso = valor.add(juros);
        return resultadoAtraso;
}
    }
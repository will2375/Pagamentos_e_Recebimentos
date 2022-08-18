package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class Debito {
    public BigDecimal recebimentoDebito(BigDecimal valor) {
        BigDecimal resultadodebito = valor.multiply(new BigDecimal(2.5 / 100));
        return resultadodebito;
    }
    public BigDecimal descontoDebito(BigDecimal valor, BigDecimal desconto){
        BigDecimal descontoFinal = valor.subtract(desconto);
        return descontoFinal;
    }
}

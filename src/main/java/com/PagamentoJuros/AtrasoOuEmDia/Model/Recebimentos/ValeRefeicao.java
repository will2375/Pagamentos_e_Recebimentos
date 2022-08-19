package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class ValeRefeicao {
    public BigDecimal recebimentoVr(BigDecimal valor) {
        BigDecimal resultadoVr = valor.multiply(new BigDecimal(4.5 / 100));
        return resultadoVr;
    }
    public BigDecimal descontoVr(BigDecimal valor, BigDecimal desconto){
        BigDecimal descontoVr = valor.subtract(desconto);
        return descontoVr;
    }
}

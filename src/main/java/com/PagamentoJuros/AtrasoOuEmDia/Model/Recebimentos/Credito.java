package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class Credito {

    public BigDecimal recebimentoCredito(BigDecimal valor) {
        BigDecimal resultadoCredito = valor.multiply(new BigDecimal(3.7 / 100));
        return resultadoCredito;
    }
    public BigDecimal descontocredito(BigDecimal valor, BigDecimal desconto){
        BigDecimal descontoFinal = valor.subtract(desconto);
        return descontoFinal;
    }
}

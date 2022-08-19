package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class Credito implements  Recebimentos{

    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        BigDecimal resultadoCredito = valor.multiply(new BigDecimal(3.7 / 100));
        return resultadoCredito;
    }

    @Override
    public BigDecimal calculoFinal(BigDecimal valor, BigDecimal desconto) {
        BigDecimal descontoFinal = valor.subtract(desconto);
        return descontoFinal;
    }
}

package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import java.math.BigDecimal;

public class ValeRefeicao implements Recebimentos{

    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        BigDecimal resultadoVr = valor.multiply(new BigDecimal(4.5 / 100));
        return resultadoVr;
    }

    @Override
    public BigDecimal calculoFinal(BigDecimal valor, BigDecimal desconto) {
        BigDecimal descontoVr = valor.subtract(desconto);
        return descontoVr;
    }
}

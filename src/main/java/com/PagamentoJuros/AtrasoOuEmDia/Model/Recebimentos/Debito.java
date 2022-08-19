package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.Pagamentos;

import java.math.BigDecimal;

public class Debito implements Recebimentos {

    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        BigDecimal resultadodebito = valor.multiply(new BigDecimal(2.5 / 100));
        return resultadodebito;
    }

    @Override
    public BigDecimal calculoFinal(BigDecimal valor, BigDecimal desconto) {
        BigDecimal descontoFinal = valor.subtract(desconto);
        return descontoFinal;
    }
}

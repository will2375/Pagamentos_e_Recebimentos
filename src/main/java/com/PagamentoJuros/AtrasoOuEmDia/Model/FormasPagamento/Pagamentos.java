package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import com.PagamentoJuros.AtrasoOuEmDia.Model.PagamentosModel;

import java.math.BigDecimal;

public interface Pagamentos {

    BigDecimal calculoPagamento(BigDecimal valorAPagar, BigDecimal diferenca);
}

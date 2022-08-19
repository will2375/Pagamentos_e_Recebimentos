package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

import java.math.BigDecimal;

public interface Pagamentos {

    BigDecimal calculoPagamento(BigDecimal valor, BigDecimal diferencial);
}

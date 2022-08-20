package com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento;

public class PagamentosFactory {

public Pagamentos getCalculoPagamento(String statusPagamento) {
    if(statusPagamento.equalsIgnoreCase("pagamento_em_dia")) {
        return new PagamentoEmDia();
    } else if (statusPagamento.equalsIgnoreCase("pagamento_atrasado")) {
        return new PagamentoAtrasado();
    }else {
        return null;
    }
}
}

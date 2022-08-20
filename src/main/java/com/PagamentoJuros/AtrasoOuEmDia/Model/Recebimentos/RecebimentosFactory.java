package com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos;

import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoAtrasado;
import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoEmDia;
import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.Pagamentos;

public class RecebimentosFactory {
    public Recebimentos getCalculoRecebimento(String statusRecebimento) {
        if (statusRecebimento.equalsIgnoreCase("cartao_credito")) {
            return new Credito();
        } else if (statusRecebimento.equalsIgnoreCase("cartao_debito")) {
            return new Debito();
        } else if (statusRecebimento.equalsIgnoreCase("vale_refeicao")) {
            return new ValeRefeicao();
        } else if (statusRecebimento.equalsIgnoreCase("DIN_PIX_CHEQUE")) {
            return new PixDinCheque();
        }else {
            return null;
        }
    }
}

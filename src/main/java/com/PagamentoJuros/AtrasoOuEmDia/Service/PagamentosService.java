package com.PagamentoJuros.AtrasoOuEmDia.Service;

import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoAtrasado;
import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoEmDia;
import com.PagamentoJuros.AtrasoOuEmDia.Model.PagamentosModel;
import com.PagamentoJuros.AtrasoOuEmDia.Repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public List<PagamentosModel> buscarPagamentos(){return pagamentosRepository.findAll();}

    public PagamentosModel pagamentoEmDia(PagamentosModel pagamentosModel, PagamentoEmDia pagamentoEmDia){
        BigDecimal resultadoDIa = pagamentoEmDia.calculoPagamento(pagamentosModel.getValorAPagar(), pagamentosModel.getDiferencaValor());
        pagamentosModel.getCodigo();
        pagamentosModel.setStatus("Pagamento_em_dia");
        pagamentosModel.getValorAPagar();
        pagamentosModel.getDiferencaValor();
        pagamentosModel.setValorPago(resultadoDIa);
        return pagamentosRepository.save(pagamentosModel);
    }

    public PagamentosModel pagamentoJuros(PagamentosModel pagamentosModel, PagamentoAtrasado pagamentoAtrasado){
        BigDecimal resultadoAtraso = pagamentoAtrasado.calculoPagamento(pagamentosModel.getValorAPagar(), pagamentosModel.getDiferencaValor());
        pagamentosModel.getCodigo();
        pagamentosModel.setStatus("Pagamento_em_atraso");
        pagamentosModel.getValorAPagar();
        pagamentosModel.getDiferencaValor();
        pagamentosModel.setValorPago(resultadoAtraso);
        return pagamentosRepository.save(pagamentosModel);
    }
}

package com.PagamentoJuros.AtrasoOuEmDia.Service;

import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Credito;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Debito;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.ValeRefeicao;
import com.PagamentoJuros.AtrasoOuEmDia.Model.RecebimentosModel;
import com.PagamentoJuros.AtrasoOuEmDia.Repository.RecebimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RecebimentosService {

    @Autowired
    private RecebimentosRepository recebimentosRepository;

    public List<RecebimentosModel> listaRecebimento() {
        return recebimentosRepository.findAll();
    }

    public RecebimentosModel cadastrarRecebimentoDinheiro(RecebimentosModel recebimentosModel) {
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_Dinheiro_pix_cheque");
        recebimentosModel.getValorAPagar();
        recebimentosModel.setDiferencaValor(new BigDecimal("0"));
        recebimentosModel.setValorPago(recebimentosModel.getValorAPagar());
        return recebimentosRepository.save(recebimentosModel);
    }
    public RecebimentosModel cadastrarRecebimentoDebito(RecebimentosModel recebimentosModel, Debito debito){
        BigDecimal descontoDebito = debito.recebimentoDebito(recebimentosModel.getValorAPagar());
        BigDecimal resultadoDebito = debito.descontoDebito(recebimentosModel.getValorAPagar(),descontoDebito);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_Debito");
        recebimentosModel.getValorAPagar();
        recebimentosModel.setDiferencaValor(descontoDebito);
        recebimentosModel.setValorPago(resultadoDebito);
        return recebimentosRepository.save(recebimentosModel);
    }

    public RecebimentosModel cadastrarRecebimentoCredito(RecebimentosModel recebimentosModel, Credito credito){
        BigDecimal descontoCredito = credito.recebimentoCredito(recebimentosModel.getValorAPagar());
        BigDecimal resultadoCredito = credito.descontocredito(recebimentosModel.getValorAPagar(),descontoCredito);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_Credito");
        recebimentosModel.getValorAPagar();
        recebimentosModel.setDiferencaValor(descontoCredito);
        recebimentosModel.setValorPago(resultadoCredito);
        return recebimentosRepository.save(recebimentosModel);
    }

    public RecebimentosModel cadastrarRecebimentoVr(RecebimentosModel recebimentosModel, ValeRefeicao valeRefeicao){
        BigDecimal descontoVr = valeRefeicao.recebimentoVr(recebimentosModel.getValorAPagar());
        BigDecimal resultadoVr = valeRefeicao.descontoVr(recebimentosModel.getValorAPagar(),descontoVr);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_vale_refeição");
        recebimentosModel.getValorAPagar();
        recebimentosModel.setDiferencaValor(descontoVr);
        recebimentosModel.setValorPago(resultadoVr);
        return recebimentosRepository.save(recebimentosModel);
    }
}

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
        recebimentosModel.setStatus("Pagamento_em_Dinheiro");
        recebimentosModel.getValorAReceber();
        recebimentosModel.setDiferencaValor(new BigDecimal("0"));
        recebimentosModel.setValorRecebido(recebimentosModel.getValorAReceber());
        return recebimentosRepository.save(recebimentosModel);
    }
    public RecebimentosModel cadastrarRecebimentoDebito(RecebimentosModel recebimentosModel, Debito debito){
        BigDecimal descontoDebito = debito.calcularDesconto(recebimentosModel.getValorAReceber());
        BigDecimal resultadoDebito = debito.calculoFinal(recebimentosModel.getValorAReceber(),descontoDebito);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_Debito");
        recebimentosModel.getValorAReceber();
        recebimentosModel.setDiferencaValor(descontoDebito);
        recebimentosModel.setValorRecebido(resultadoDebito);
        return recebimentosRepository.save(recebimentosModel);
    }

    public RecebimentosModel cadastrarRecebimentoCredito(RecebimentosModel recebimentosModel, Credito credito){
        BigDecimal descontoCredito = credito.calcularDesconto(recebimentosModel.getValorAReceber());
        BigDecimal resultadoCredito = credito.calculoFinal(recebimentosModel.getValorAReceber(),descontoCredito);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_Credito");
        recebimentosModel.getValorAReceber();
        recebimentosModel.setDiferencaValor(descontoCredito);
        recebimentosModel.setValorRecebido(resultadoCredito);
        return recebimentosRepository.save(recebimentosModel);
    }

    public RecebimentosModel cadastrarRecebimentoVr(RecebimentosModel recebimentosModel, ValeRefeicao valeRefeicao){
        BigDecimal descontoVr = valeRefeicao.calcularDesconto(recebimentosModel.getValorAReceber());
        BigDecimal resultadoVr = valeRefeicao.calculoFinal(recebimentosModel.getValorAReceber(),descontoVr);
        recebimentosModel.getCodigo();
        recebimentosModel.setStatus("Pagamento_em_vale_refeição");
        recebimentosModel.getValorAReceber();
        recebimentosModel.setDiferencaValor(descontoVr);
        recebimentosModel.setValorRecebido(resultadoVr);
        return recebimentosRepository.save(recebimentosModel);
    }
}

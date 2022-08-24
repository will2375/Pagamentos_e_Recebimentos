package com.PagamentoJuros.AtrasoOuEmDia.Service;

import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.RecebimentosFactory;

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

    public List<RecebimentosModel> findyRecebimentos (String status){
        return recebimentosRepository.findByStatus(status);
    }

    public RecebimentosModel cadastrarRecebimento(RecebimentosModel recebimentosModel, RecebimentosFactory recebimentosFactory) {
        BigDecimal resultado = recebimentosFactory.getCalculoRecebimento(recebimentosModel.getStatus()).calcularDesconto(recebimentosModel.getValorAReceber());
        BigDecimal resultadoFinal = recebimentosModel.getValorAReceber().subtract(resultado);
        recebimentosModel.getCodigo();
        recebimentosModel.getStatus();
        recebimentosModel.getValorAReceber();
        recebimentosModel.setDiferencaValor(resultado);
        recebimentosModel.setValorRecebido(resultadoFinal);
        return recebimentosRepository.save(recebimentosModel);
    }
}

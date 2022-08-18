package com.PagamentoJuros.AtrasoOuEmDia.Service;

import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Debito;
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
}

package com.PagamentoJuros.AtrasoOuEmDia.controller;

import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Credito;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Debito;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.RecebimentosFactory;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.ValeRefeicao;
import com.PagamentoJuros.AtrasoOuEmDia.Model.RecebimentosModel;
import com.PagamentoJuros.AtrasoOuEmDia.Service.RecebimentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecebimentoController {

    @Autowired
    RecebimentosService recebimentosService;

    @GetMapping(path = "/recebimentos")
    public List<RecebimentosModel> buscarRecebimentos() {
        return recebimentosService.listaRecebimento();
    }

    @PostMapping(path = "/recebimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentosModel cadastrarRecebimentoDinheiro(@RequestBody RecebimentosModel recebimentosModel, RecebimentosFactory recebimentosFactory){
        return recebimentosService.cadastrarRecebimento(recebimentosModel, recebimentosFactory);
    }
}

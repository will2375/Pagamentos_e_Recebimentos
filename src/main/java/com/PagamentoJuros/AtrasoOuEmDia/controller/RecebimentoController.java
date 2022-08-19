package com.PagamentoJuros.AtrasoOuEmDia.controller;

import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Credito;
import com.PagamentoJuros.AtrasoOuEmDia.Model.Recebimentos.Debito;
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

    @PostMapping(path = "/recebimentos/dinheiro")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentosModel cadastrarRecebimentoDinheiro(@RequestBody RecebimentosModel recebimentosModel){
        return recebimentosService.cadastrarRecebimentoDinheiro(recebimentosModel);
    }

    @PostMapping(path = "/recebimentos/debito")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentosModel cadastrarRecebimentoDebito(@RequestBody RecebimentosModel recebimentosModel, Debito debito){
        return recebimentosService.cadastrarRecebimentoDebito(recebimentosModel,debito);
    }

    @PostMapping(path = "/recebimentos/credito")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentosModel cadastrarRecebimentoCredito(@RequestBody RecebimentosModel recebimentosModel, Credito credito){
        return recebimentosService.cadastrarRecebimentoCredito(recebimentosModel, credito);
    }

    @PostMapping(path = "/recebimentos/vr")
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentosModel cadastrarRecebimentoVr(@RequestBody RecebimentosModel recebimentosModel, ValeRefeicao valeRefeicao) {
        return recebimentosService.cadastrarRecebimentoVr(recebimentosModel, valeRefeicao);
    }
}

package com.PagamentoJuros.AtrasoOuEmDia.controller;

import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoAtrasado;
import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentoEmDia;
import com.PagamentoJuros.AtrasoOuEmDia.Model.FormasPagamento.PagamentosFactory;
import com.PagamentoJuros.AtrasoOuEmDia.Model.PagamentosModel;
import com.PagamentoJuros.AtrasoOuEmDia.Service.PagamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping(path = "/pagamentos")
    public List<PagamentosModel> buscarPagamentos() {return pagamentosService.buscarPagamentos();}

    @PostMapping(path = "/pagamentos/antecipado")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentosModel cadastrarPagamento(@RequestBody PagamentosModel pagamentosModel, PagamentosFactory pagamentosFactory) {
        return pagamentosService.pagamentoEmDia(pagamentosModel, pagamentosFactory);
    }

    @PostMapping(path = "/pagamentos/atrasado")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentosModel cadastrarPagamentoAtrasado(@RequestBody PagamentosModel pagamentosModel, PagamentosFactory pagamentosFactory) {
        return pagamentosService.pagamentoJuros(pagamentosModel, pagamentosFactory);
    }
}
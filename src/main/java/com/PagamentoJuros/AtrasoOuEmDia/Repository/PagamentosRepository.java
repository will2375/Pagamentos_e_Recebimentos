package com.PagamentoJuros.AtrasoOuEmDia.Repository;

import com.PagamentoJuros.AtrasoOuEmDia.Model.PagamentosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentosRepository extends JpaRepository<PagamentosModel, Long> {
}

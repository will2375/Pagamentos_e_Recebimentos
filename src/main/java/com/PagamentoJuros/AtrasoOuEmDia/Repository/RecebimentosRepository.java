package com.PagamentoJuros.AtrasoOuEmDia.Repository;

import com.PagamentoJuros.AtrasoOuEmDia.Model.RecebimentosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecebimentosRepository extends JpaRepository<RecebimentosModel, Long> {
}

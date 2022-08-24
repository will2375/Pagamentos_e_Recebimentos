package com.PagamentoJuros.AtrasoOuEmDia.Repository;

import com.PagamentoJuros.AtrasoOuEmDia.Model.RecebimentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecebimentosRepository extends JpaRepository<RecebimentosModel, Long> {
    public List<RecebimentosModel> findByStatus (String status);
}

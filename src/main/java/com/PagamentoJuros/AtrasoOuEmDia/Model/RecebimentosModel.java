package com.PagamentoJuros.AtrasoOuEmDia.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "recebimentos")
public class RecebimentosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50,nullable = false)
    private String status;
    @Column(length = 10, nullable = false)
    private BigDecimal valorAReceber;
    @Column(length = 10, nullable = false)
    private BigDecimal diferencaValor;
    @Column(length = 10, nullable = false)
    private BigDecimal valorRecebido;
}

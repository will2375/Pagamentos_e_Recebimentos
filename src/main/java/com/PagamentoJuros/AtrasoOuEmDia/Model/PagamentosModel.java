package com.PagamentoJuros.AtrasoOuEmDia.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name= "Pagamentos")
public class PagamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50,nullable = false)
    private String status;
    @Column(length = 10, nullable = false)
    private BigDecimal valorAPagar;
    @Column(length = 10, nullable = false)
    private BigDecimal diferencaValor;
    @Column(length = 10, nullable = false)
    private BigDecimal valorPago;
}

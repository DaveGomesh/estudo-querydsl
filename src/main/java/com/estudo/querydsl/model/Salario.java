package com.estudo.querydsl.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "salario")
public class Salario implements Serializable {
    
    @Column(name = "id_salario")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSalario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_funcionario", nullable = false)
    private Funcionario funcionario;

    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Override
    public String toString() {

        final String result = ("Salario (" +
            "id=" + idSalario +
            ", idFun=" + funcionario.getIdFuncionario() +
            ", valor=" + valor +
            ", dataInicio=" + dataInicio +
            ", dataFim=" + dataFim +
            ")"
        );

        return result;
    }
}

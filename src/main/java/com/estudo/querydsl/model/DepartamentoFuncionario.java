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
@Table(name = "depart_func")
public class DepartamentoFuncionario implements Serializable{
    
    @Column(name = "id_departamento")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamenoFuncionario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_departamento", nullable = false)
    private Departamento departamento;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_funcionario", nullable = false)
    private Funcionario funcionario;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;
}

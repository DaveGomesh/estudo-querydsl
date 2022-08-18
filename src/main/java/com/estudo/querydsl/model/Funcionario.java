package com.estudo.querydsl.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Funcionario {
    
    @Column(name = "id_employee")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFucionario;
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate dataNasc;
    
    @Column(name = "first_name", nullable = false, length = 14)
    private String nome;
    
    @Column(name = "last_name", nullable = false, length = 16)
    private String sobrenome;
    
    @Column(name = "last_name", nullable = false, length = 1)
    private String sexo;
    
    @Column(name = "hire_date", nullable = false)
    private LocalDate dataAdmissao;
}

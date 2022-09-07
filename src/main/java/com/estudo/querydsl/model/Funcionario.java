package com.estudo.querydsl.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estudo.querydsl.enumerate.Sexo;

import lombok.Data;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    
    @Column(name = "id_funcionario")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionario;
    
    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNasc;
    
    @Column(name = "nome", nullable = false, length = 14)
    private String nome;
    
    @Column(name = "sobrenome", nullable = false, length = 16)
    private String sobrenome;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false, length = 1)
    private Sexo sexo;
    
    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @Override
    public final String toString() {

        final String result = ("Funcionario(" +
            "id=" + idFuncionario + 
            ", nome=" + nome + 
            ", sexo=" + sexo + 
            ", dataNasc=" + dataNasc + 
            ", dataAdmissao=" + dataAdmissao + 
            ")"
        );

        return result;
    }
}

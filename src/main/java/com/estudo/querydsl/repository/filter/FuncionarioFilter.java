package com.estudo.querydsl.repository.filter;

import java.time.LocalDate;

import com.estudo.querydsl.enumerate.Sexo;
import com.estudo.querydsl.filter.IntegerFilter;

import lombok.Data;

@Data
public class FuncionarioFilter {
    
    private IntegerFilter idFuncionario;

    private String nome;
    private String sobrenome;
    private Sexo sexo;

    private LocalDate dataNascInicial;
    private LocalDate dataNascFinal;

    private LocalDate dataAdmissaoInicial;
    private LocalDate dataAdmissaoFinal;
}

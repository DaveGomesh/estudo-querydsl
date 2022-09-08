package com.estudo.querydsl.repository.funcionario;

import java.util.List;

import com.estudo.querydsl.model.Funcionario;
import com.estudo.querydsl.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
    
    List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter);
}

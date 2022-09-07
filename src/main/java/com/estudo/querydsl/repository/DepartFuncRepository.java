package com.estudo.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.estudo.querydsl.model.DepartamentoFuncionario;

public interface DepartFuncRepository extends 
    JpaRepository<DepartamentoFuncionario, Integer>, 
    QuerydslPredicateExecutor<DepartamentoFuncionario> {
    
}

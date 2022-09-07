package com.estudo.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.estudo.querydsl.model.Funcionario;

@Repository
public interface FuncionarioRepository extends 
    JpaRepository<Funcionario, Integer>, 
    QuerydslPredicateExecutor<Funcionario> {
    
}

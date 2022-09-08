package com.estudo.querydsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.estudo.querydsl.model.Funcionario;
import com.estudo.querydsl.repository.funcionario.FuncionarioRepositoryQuery;

@Repository
public interface FuncionarioRepository extends 
    JpaRepository<Funcionario, Integer>, 
    QuerydslPredicateExecutor<Funcionario>,
    FuncionarioRepositoryQuery {
    
    List<Funcionario> findByNomeStartsWith(String nome);
}

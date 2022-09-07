package com.estudo.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.estudo.querydsl.model.Salario;

public interface SalarioRepository extends 
    JpaRepository<Salario, Integer>, 
    QuerydslPredicateExecutor<Salario> {
    
}

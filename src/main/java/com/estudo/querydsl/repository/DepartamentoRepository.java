package com.estudo.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.estudo.querydsl.model.Departamento;

public interface DepartamentoRepository extends 
    JpaRepository<Departamento, Integer>,
    QuerydslPredicateExecutor<Departamento> {
    
}

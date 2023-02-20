package com.estudo.QueryDSL.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.repository.query.LivroRepositoryQuery;

@Repository
public interface LivroRepository extends
    JpaRepository<Livro, Integer>,
    QuerydslPredicateExecutor<Livro>,
    LivroRepositoryQuery {

}

package com.estudo.QueryDSL.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.repository.filter.LivroFilter;

public interface LivroRepositoryQuery {
    Page<Livro> filtrar(LivroFilter livroFilter, Pageable pageable);
}

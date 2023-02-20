package com.estudo.QueryDSL.domain.repository.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.domain.repository.filter.LivroFilter;
import com.estudo.QueryDSL.domain.repository.query.LivroRepositoryQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class LivroRepositoryQueryImpl implements LivroRepositoryQuery {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    private JPAQuery<Livro> query;

    private QLivro qLivro = QLivro.livro;
    private LivroFilter livroFilter;

    private Pageable pageable;
    private Page<Livro> page;

    @Override
    public Page<Livro> filtrar(LivroFilter livroFilter, Pageable pageable) {

        this.livroFilter = livroFilter;
        this.pageable = pageable;

        montarQuery();
        buscar();

        return page;
    }

    private void montarQuery(){
        query = (jpaQueryFactory
            .select(qLivro).from(qLivro)
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
        );
        aplicarFiltros();
    }

    private void aplicarFiltros(){
        aplicarFiltroTitulo();
        aplicarFiltroCategoria();
        aplicarFiltroValor();
        aplicarFiltroDisponivel();
    }

    private void aplicarFiltroTitulo(){
        if(livroFilter.getTitulo() != null){
            query.where(qLivro.titulo.eq(livroFilter.getTitulo()));
        }
    }

    private void aplicarFiltroCategoria(){
        if(livroFilter.getCategoria() != null){
            query.where(qLivro.categoria.idCategoria.eq(
                livroFilter.getCategoria()
            ));
        }
    }

    private void aplicarFiltroValor(){
        if(livroFilter.getValorMinimo() != null && livroFilter.getValorMaximo() != null){
            query.where(qLivro.valor.between(
                livroFilter.getValorMinimo(), livroFilter.getValorMaximo()
            ));
        }
    }

    private void aplicarFiltroDisponivel(){
        if(livroFilter.getDisponivel() != null){
            query.where(qLivro.disponivel.eq(livroFilter.getDisponivel()));
        }
    }

    private void buscar(){
        List<Livro> livros = query.fetch();
        page = new PageImpl<>(livros, pageable, livros.size());
    }
}

package com.estudo.QueryDSL.parte07_ordenacoes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_OrderBy {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void orderBy(){

        QLivro qLivro = QLivro.livro;

        StringPath titulo = qLivro.titulo;
        NumberPath<Double> valor = qLivro.valor;

        JPAQuery<?> query = (jpaQueryFactory
            .select(titulo, valor)
            .from(qLivro)
            .orderBy(titulo.asc(), valor.desc())
            // .orderBy(titulo.asc())
            // .orderBy(valor.desc())
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

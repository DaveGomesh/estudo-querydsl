package com.estudo.QueryDSL.parte04_juncoes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QCategoria;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_InnerJoin {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void from(){

        QLivro qLivro = QLivro.livro;
        QCategoria qCategoria = QCategoria.categoria;

        JPAQuery<?> query = (jpaQueryFactory
            .select(qLivro, qCategoria)
            .from(qLivro).from(qCategoria)
            // .from(qLivro, qCategoria)
            .where(qLivro.categoria.eq(qCategoria))
            // .where(qLivro.categoria.idCategoria.eq(qCategoria.idCategoria))
        );

        Printter.print(query);
    }

    @Test
    void join(){

        QLivro qLivro = QLivro.livro;
        QCategoria qCategoria = QCategoria.categoria;

        JPAQuery<?> query = (jpaQueryFactory
            .select(qLivro, qCategoria)
            .from(qLivro)
            .innerJoin(qLivro.categoria, qCategoria) // Inner Join == Join
            // .innerJoin(qCategoria).on(qLivro.categoria.eq(qCategoria))
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

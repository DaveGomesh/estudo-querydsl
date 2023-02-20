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
public class Topico02_OutrosJoins {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void outros(){

        QLivro qLivro = QLivro.livro;
        QCategoria qCategoria = QCategoria.categoria;

        JPAQuery<?> query = (jpaQueryFactory
            .select(qLivro, qCategoria)
            .from(qLivro)
            .leftJoin(qCategoria).on(qLivro.categoria.eq(qCategoria))
            .rightJoin(qCategoria).on(qLivro.categoria.eq(qCategoria))
        );

        // Os outros tipos de join
        // devem ser construídos como no SQL comum

        Printter.print(query);
    }
}

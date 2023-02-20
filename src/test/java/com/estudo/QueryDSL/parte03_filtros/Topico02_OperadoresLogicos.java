package com.estudo.QueryDSL.parte03_filtros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico02_OperadoresLogicos {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void and_or(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(
                // titulo = 'It - A coisa' AND valor < 50.00 OR valor > 60.00
                qLivro.titulo.eq("It - A coisa")
                .and(qLivro.valor.lt(40.00))
                .or(qLivro.valor.gt(60.00))
            )
        );

        Printter.print(query);
    }

    @Test
    void where(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(
                qLivro.titulo.eq("It - A coisa")
                .and(qLivro.valor.lt(40.00))
                .or(qLivro.valor.gt(60.00))
            )
        );

        Printter.print(query);
    }

    @Test
    void parenteses(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(
                // titulo = 'It - A coisa' AND (valor < 50.00 OR valor > 60.00)
                qLivro.titulo.eq("It - A coisa")
                .and(qLivro.valor.lt(40.00)
                    .or(qLivro.valor.gt(60.00))
                )
            )
        );

        Printter.print(query);
    }

    @Test
    void not(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(
                // NOT titulo = 'It - A coisa' AND NOT valor < 50.00 OR NOT valor > 60.00 AND NOT disponivel
                qLivro.titulo.eq("It - A coisa").not()
                .or(qLivro.valor.gt(60.00)).not()
                .and(qLivro.disponivel.not())
            )
        );

        Printter.print(query);
    }

    @Test
    void negando_expressoes_completas(){

        QLivro qLivro = QLivro.livro;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qLivro.titulo.eq("It - A coisa"));
        booleanBuilder.or(qLivro.valor.gt(60.00));

        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(
                // NOT (titulo = 'It - A coisa' AND valor < 50.00 OR valor > 60.00)
                booleanBuilder.not()
            )
        );

        Printter.print(query);
    }
}

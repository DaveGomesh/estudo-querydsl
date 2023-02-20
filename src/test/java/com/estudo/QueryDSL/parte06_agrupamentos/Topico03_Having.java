package com.estudo.QueryDSL.parte06_agrupamentos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico03_Having {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void having(){
        
        QLivro qLivro = QLivro.livro;

        StringPath nomeCat = qLivro.categoria.nome;
        NumberPath<Double> valor = qLivro.valor;
        NumberExpression<Double> media = valor.avg();

        JPAQuery<?> query = (jpaQueryFactory
            .select(nomeCat, media)
            .from(qLivro)
            .groupBy(nomeCat)
            .having(media.lt(30.00))
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

package com.estudo.QueryDSL.parte06_agrupamentos;

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
public class Topico01_GroupBy {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void groupBy(){

        QLivro qLivro = QLivro.livro;

        StringPath nomeCat = qLivro.categoria.nome;
        NumberPath<Double> valor = qLivro.valor;

        JPAQuery<?> query = (jpaQueryFactory
            .select(nomeCat)
            .from(qLivro)
            .where(valor.gt(30.00))
            .groupBy(nomeCat)
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

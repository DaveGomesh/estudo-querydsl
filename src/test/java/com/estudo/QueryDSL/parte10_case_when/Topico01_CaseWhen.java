package com.estudo.QueryDSL.parte10_case_when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_CaseWhen {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void case_when(){

        QLivro qLivro = QLivro.livro;

        StringPath titulo = qLivro.titulo;
        NumberPath<?> valor = qLivro.valor;

        Expression<String> status = (new CaseBuilder()
            .when(valor.lt(20.00)).then("Preço Baixo")
            .when(valor.between(20.00, 40.00)).then("Preço Médio")
            .when(valor.gt(40.00)).then("Preço Alto")
            .otherwise("Preço muito alto")
        );

        JPAQuery<?> query = (jpaQueryFactory
            .select(titulo, valor, status)
            .from(qLivro)
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }

    @Test
    void case_when_com_equals(){

        QLivro qLivro = QLivro.livro;

        StringPath titulo = qLivro.titulo;
        BooleanPath disponivel = qLivro.disponivel;

        Expression<String> status = (disponivel
            .when(true).then("Livro disponível")
            .when(false).then("Livro indisponível")
            .otherwise("Disponibilidade não informada")
        );

        JPAQuery<?> query = (jpaQueryFactory
            .select(titulo, status)
            .from(qLivro)
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

package com.estudo.QueryDSL.parte05_apelidos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QCategoria;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Apelidos {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void paths(){

        QLivro qLivro = QLivro.livro;

        NumberPath<Double> valor = qLivro.valor;
        StringPath titulo = qLivro.titulo;

        QCategoria categoria = qLivro.categoria;
        StringPath nomeCat = categoria.nome;

        JPAQuery<?> query = (jpaQueryFactory
            .select(titulo, valor, nomeCat)
            .from(qLivro)
            .where(valor.gt(30.00))
            .where(nomeCat.eq("Terror"))
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

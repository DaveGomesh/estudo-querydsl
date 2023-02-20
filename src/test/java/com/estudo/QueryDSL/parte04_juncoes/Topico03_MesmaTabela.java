package com.estudo.QueryDSL.parte04_juncoes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico03_MesmaTabela {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void join_com_mesma_tabela(){
        
        QLivro qLivro1 = QLivro.livro;
        QLivro qLivro2 = new QLivro("livro2");

        JPAQuery<?> query = (jpaQueryFactory
            .select(qLivro1, qLivro2)
            .from(qLivro1)
            .join(qLivro2).on(qLivro1.eq(qLivro2))
        );

        Printter.print(query);
    }
}
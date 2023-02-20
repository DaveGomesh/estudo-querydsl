package com.estudo.QueryDSL.parte01_consultas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Categoria;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico03_Distinct {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void distinct(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Categoria> query = (jpaQueryFactory
            .select(qLivro.categoria).distinct()
            .from(qLivro)
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
    
}

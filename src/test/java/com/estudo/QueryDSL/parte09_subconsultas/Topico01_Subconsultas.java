package com.estudo.QueryDSL.parte09_subconsultas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Subconsultas {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void subconsultas(){
        
        QLivro qLivro1 = QLivro.livro;
        QLivro qLivro2 = new QLivro("qLivro2");

        JPAQuery<?> query = (jpaQueryFactory
            .select(qLivro1).from(qLivro1)
            .where(qLivro1.valor.goe(JPAExpressions
                .select(qLivro2.valor.avg())
                .from(qLivro2)
            ))
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
}

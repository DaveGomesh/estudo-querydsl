package com.estudo.QueryDSL.parte08_limites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QEmprestimo;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Limites {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void limites(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;

        JPAQuery<?> query = (jpaQueryFactory
            .selectFrom(qEmprestimo)
            .offset(5)
            .limit(3)
        );

        Printter.print(query);
        Printter.printList(query.fetch());
    }
    
}

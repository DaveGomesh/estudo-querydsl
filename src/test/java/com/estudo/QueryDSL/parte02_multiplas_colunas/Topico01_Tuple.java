package com.estudo.QueryDSL.parte02_multiplas_colunas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Emprestimo;
import com.estudo.QueryDSL.domain.model.QEmprestimo;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Tuple {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void sem_tuple(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;
        JPAQuery<Emprestimo> query = (jpaQueryFactory
            .selectFrom(qEmprestimo)
        );

        Printter.print(query);
        assertTrue(query.fetchFirst() instanceof Emprestimo);
    }

    @Test
    void tuple(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;
        JPAQuery<Tuple> query = (jpaQueryFactory
            .select(
                qEmprestimo.idEmprestimo,
                qEmprestimo.dataEmprestimo, 
                qEmprestimo.dataDevolucao
            ).from(qEmprestimo)
        );

        Printter.print(query);
        assertTrue(query.fetchFirst() instanceof Tuple);
    }

    @Test
    void list_tuple(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;
        JPAQuery<Tuple> query = (jpaQueryFactory
            .select(
                qEmprestimo.idEmprestimo,
                qEmprestimo.dataEmprestimo, 
                qEmprestimo.dataDevolucao
            ).from(qEmprestimo)
        );

        Printter.print(query);
        assertTrue(query.fetch() instanceof List<Tuple>);
    }
}

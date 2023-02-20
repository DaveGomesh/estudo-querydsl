package com.estudo.QueryDSL.parte02_multiplas_colunas;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QEmprestimo;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico02_Get {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void get(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;
        JPAQuery<Tuple> query = (jpaQueryFactory
            .select(
                qEmprestimo.idEmprestimo,
                qEmprestimo.dataEmprestimo, 
                qEmprestimo.dataDevolucao
            ).from(qEmprestimo)
        );

        Tuple tuple = query.fetchFirst();

        Integer   idEmpre = tuple.get(qEmprestimo.idEmprestimo);
        LocalDate dataEmp = tuple.get(qEmprestimo.dataEmprestimo);
        LocalDate dataDev = tuple.get(qEmprestimo.dataDevolucao);

        Printter.print(
            "ID: "        + idEmpre + "\n" +
            "Data Emp.: " + dataEmp + "\n" +
            "Data Dev.: " + dataDev + "\n"
        );
    }

    @Test
    void get_com_numero_da_coluna(){

        QEmprestimo qEmprestimo = QEmprestimo.emprestimo;
        JPAQuery<Tuple> query = (jpaQueryFactory
            .select(
                qEmprestimo.idEmprestimo,   // 0
                qEmprestimo.dataEmprestimo, // 1
                qEmprestimo.dataDevolucao   // 2
            ).from(qEmprestimo)
        );

        Tuple tuple = query.fetchFirst();

        Integer   idEmpre = tuple.get(0, Integer.class);
        LocalDate dataEmp = tuple.get(1, LocalDate.class);
        LocalDate dataDev = tuple.get(2, LocalDate.class);

        Printter.print(
            "ID: "        + idEmpre + "\n" +
            "Data Emp.: " + dataEmp + "\n" +
            "Data Dev.: " + dataDev + "\n"
        );
    }
    
}

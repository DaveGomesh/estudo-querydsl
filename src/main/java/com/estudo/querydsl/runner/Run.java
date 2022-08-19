package com.estudo.querydsl.runner;

import javax.persistence.EntityManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.estudo.querydsl.model.QSalario;
import com.estudo.querydsl.model.Salario;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.DatePart;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLExpressions;

import lombok.Builder;

@Builder
@Component
public class Run implements CommandLineRunner {

    // private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        
        QSalario qSalario = QSalario.salario;
        
        final JPASQLQuery<Salario> query = new JPASQLQuery<>(entityManager, MySQLTemplates.DEFAULT);

        // Expressions.predicate(Ops.STARTS_WITH, personFirstName, constant);
        // var diff = Expressions.numberOperation(Integer.class, Ops.DateTimeOps.DIFF_DAYS, qSalario.dataFim, qSalario.dataInicio);
        // NumberOperation.

        System.out.println(query
            .select(SQLExpressions.datediff(DatePart.day, qSalario.dataInicio, qSalario.dataFim))
            .from(qSalario)
            .where(qSalario.idSalario.eq(256))
            .fetchFirst()
        );
    }
    
}

package com.estudo.QueryDSL.parte01_consultas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Cliente;
import com.estudo.QueryDSL.domain.model.QCliente;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_SelectFrom {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void select_E_From(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .select(qCliente)
            .from(qCliente)
        );

        Printter.print(query);
    }

    @Test
    void selectFrom(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .selectFrom(qCliente)
        );

        Printter.print(query);
    }

    @Test
    void from_sem_select(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<?> query = (jpaQueryFactory
            .from(qCliente)
        );

        Printter.print(query);
    }
}

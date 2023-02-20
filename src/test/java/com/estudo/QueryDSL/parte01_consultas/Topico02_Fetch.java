package com.estudo.QueryDSL.parte01_consultas;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Cliente;
import com.estudo.QueryDSL.domain.model.QCliente;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.NonUniqueResultException;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico02_Fetch {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    
    @Test
    void fetch(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .select(qCliente)
            .from(qCliente)
        );

        List<Cliente> clientes = query.fetch();
        Printter.printList(clientes);
    }

    @Test
    void fetchFirst(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .select(qCliente)
            .from(qCliente)
        );

        Cliente cliente1 = query.fetchFirst();
        Printter.print(cliente1);
    }

    @Test
    void fetchOne(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .select(qCliente)
            .from(qCliente)
        );

        assertThrows(NonUniqueResultException.class, () -> {
            query.fetchOne();
        });

        query.where(qCliente.idCliente.eq(1));
        // query.limit(1);
        
        Cliente cliente = query.fetchOne();
        Printter.print(cliente);
    }

    @Test
    void fetch_sem_from(){

        QCliente qCliente = QCliente.cliente;
        JPAQuery<Cliente> query = (jpaQueryFactory
            .select(qCliente)
        );

        assertThrows(IllegalArgumentException.class, () -> {
            query.fetch();
        });
    }
}

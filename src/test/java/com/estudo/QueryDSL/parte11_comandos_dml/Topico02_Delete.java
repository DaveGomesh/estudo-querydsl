package com.estudo.QueryDSL.parte11_comandos_dml;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.domain.repository.LivroRepository;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico02_Delete {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    @Transactional
    void delete(){

        QLivro qLivro = QLivro.livro;
        JPADeleteClause query = (jpaQueryFactory
            .delete(qLivro)
            .where(qLivro.idLivro.eq(10))
        );
        
        Printter.print(query);
        Printter.print((Long) query.execute());

        assertThrows(NoSuchElementException.class, () -> {
            livroRepository.findById(10).orElseThrow();
        });
    }
    
}

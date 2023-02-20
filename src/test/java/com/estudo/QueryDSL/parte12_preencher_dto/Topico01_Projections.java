package com.estudo.QueryDSL.parte12_preencher_dto;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.api.dto.response.LivroResponse;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)   
public class Topico01_Projections {
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    
    @Test
    void bean(){

        QLivro qLivro = QLivro.livro;

        NumberPath<?> idLivro = qLivro.idLivro;
        StringPath titulo = qLivro.titulo;
        NumberPath<?> valor = qLivro.valor;

        List<LivroResponse> livros = (jpaQueryFactory
            .select(Projections.bean(
                LivroResponse.class, idLivro, titulo, valor
            )).from(qLivro)
            .fetch()
        );

        Printter.printList(livros);
    }
}

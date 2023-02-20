package com.estudo.QueryDSL.parte13_predicate_executor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.domain.repository.LivroRepository;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.core.BooleanBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)   
public class Topico01_QuerydslPredicateExecutor {
    
    @Autowired
    private LivroRepository livroRepository;

    @Test
    void querydslPredicateExecutor(){
        
        QLivro qLivro = QLivro.livro;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qLivro.valor.lt(30.00));
        booleanBuilder.and(qLivro.disponivel.isFalse());

        Iterable<Livro> livros = livroRepository.findAll(booleanBuilder);

        Printter.printList(livros);

    }

}

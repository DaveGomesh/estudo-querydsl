package com.estudo.QueryDSL.parte11_comandos_dml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Categoria;
import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.domain.repository.CategoriaRepository;
import com.estudo.QueryDSL.domain.repository.LivroRepository;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Update {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    @Transactional
    void update(){

        Categoria terror = categoriaRepository.findById(1).orElseThrow();

        QLivro qLivro = QLivro.livro;
        JPAUpdateClause query = (jpaQueryFactory
            .update(qLivro)
            .set(qLivro.titulo, "Meu Livro")
            .set(qLivro.valor, 39.90)
            .set(qLivro.categoria, terror)
            .where(qLivro.idLivro.eq(10))
        );

        Printter.print(query);
        Printter.print((Long) query.execute());

        Livro livro = livroRepository.findById(10).orElseThrow();
        assertEquals(livro.getTitulo(), "Meu Livro");
        assertEquals(livro.getValor(), 39.90);
        assertEquals(livro.getCategoria(), terror);
    }
}

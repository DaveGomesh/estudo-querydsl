package com.estudo.QueryDSL.parte03_filtros;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.estudo.QueryDSL.domain.model.Emprestimo;
import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.model.QLivro;
import com.estudo.QueryDSL.domain.repository.EmprestimoRepository;
import com.estudo.QueryDSL.utils.Printter;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Topico01_Comparacoes {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Test
    void comparacoes_basicas(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(qLivro.valor.eq(50.00))   // Equals           : Igual (=)
            .where(qLivro.valor.ne(50.00))   // Not Equals       : Diferente (!=)
            .where(qLivro.valor.gt(50.00))   // Greater Than     : Maior que (>)
            .where(qLivro.valor.lt(50.00))   // Less Than        : Menor que (<)
            .where(qLivro.valor.goe(50.00))  // Greater or Equals: Maior que ou igual (>=)
            .where(qLivro.valor.loe(50.00))  // Less or Equals   : Menor que or igual (<=)
        );

        Printter.print(query);
        query.fetch();
    }

    @Test
    void nulos(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(qLivro.valor.isNull())
            .where(qLivro.valor.isNotNull())
        );

        Printter.print(query);
        query.fetch();
    }

    @Test
    void listas(){

        // Também podem ser feitas a partir de uma subquery
        List<Double> valores = Arrays.asList(45.90, 50.00, 65.35);
        Emprestimo emp = emprestimoRepository.findById(1).orElseThrow();

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(qLivro.valor.in(valores))
            .where(qLivro.emprestimos.contains(emp))
            .where(qLivro.emprestimos.any().eq(emp)) // EXISTS
        );

        Printter.print(query);
        query.fetch();
    }

    @Test
    void between(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)
            .where(qLivro.valor.between(45.90, 65.35))
            // valor BETWEEN 45.90 AND 65.35
        );

        Printter.print(query);
        query.fetch();
    }

    @Test
    void strings(){

        QLivro qLivro = QLivro.livro;
        JPAQuery<Livro> query = (jpaQueryFactory
            .selectFrom(qLivro)

            .where(qLivro.titulo.like("%Caçador%"))
            // titulo LIKE '%Caçador%'

            .where(qLivro.titulo.likeIgnoreCase("%Caçador%"))
            // LOWER(titulo) LIKE LOWER('%Caçador%')
            // titulo ILIKE '%Caçador%'

            // Outras comparações
            // startsWith, endsWith, contains, isEmpty, isNotEmpty...
        );

        Printter.print(query);
        query.fetch();
    }
}

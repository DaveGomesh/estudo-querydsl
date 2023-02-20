package com.estudo.QueryDSL.parte14_criando_filtros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.estudo.QueryDSL.domain.model.Livro;
import com.estudo.QueryDSL.domain.repository.LivroRepository;
import com.estudo.QueryDSL.domain.repository.filter.LivroFilter;
import com.estudo.QueryDSL.utils.Printter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)   
public class Topico01_Criando_Filtros {

    @Autowired
    private LivroRepository livroRepository;

    @Test
    void usandoFiltros(){

        Pageable pageable = PageRequest.of(0, 10);

        LivroFilter livroFilter = new LivroFilter();
        livroFilter.setValorMinimo(20.00);
        livroFilter.setValorMaximo(40.00);
        livroFilter.setCategoria(2);
        livroFilter.setDisponivel(false);

        Page<Livro> page = livroRepository.filtrar(livroFilter, pageable);
        
        Printter.print(page);
        Printter.printList(page.getContent());
    }
}
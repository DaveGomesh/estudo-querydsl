package com.estudo.querydsl.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.estudo.querydsl.filter2.IntegerFilter;
import com.estudo.querydsl.filter2.options.NumberFilterOption;
import com.estudo.querydsl.model.Funcionario;
import com.estudo.querydsl.repository.FuncionarioRepository;
import com.estudo.querydsl.repository.filter.FuncionarioFilter;

import lombok.Builder;

@Builder
@Component
public class Run implements CommandLineRunner {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public void run(String... args) throws Exception {

        final FuncionarioFilter funcionarioFilter = new FuncionarioFilter();

        final IntegerFilter integerFilter = new IntegerFilter();
        integerFilter.setNumberFilterOption(NumberFilterOption.GREATER_OR_EQUALS_ANY);
        integerFilter.setNumbers(Arrays.asList(48, 39));
        // integerFilter.setDenial(true);

        funcionarioFilter.setIdFuncionario(integerFilter);

        final List<Funcionario> listaFunc = (
            funcionarioRepository.filtrar(funcionarioFilter)
        );

        System.out.println("===============================");
        System.out.println(listaFunc);
        System.out.println("===============================");
    }
    
}

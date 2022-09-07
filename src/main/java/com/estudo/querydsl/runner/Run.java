package com.estudo.querydsl.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class Run implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("No testes!");        
    }
    
}

package com.estudo.querydsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.estudo.querydsl.filter2.PredicateFactory;

@Configuration
public class PredicateFactoryConfig {
    
    @Bean
    public PredicateFactory predicateFactory(){
        return new PredicateFactory();
    }
}

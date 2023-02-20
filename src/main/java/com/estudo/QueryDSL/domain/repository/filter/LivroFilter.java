package com.estudo.QueryDSL.domain.repository.filter;

import lombok.Data;

@Data
public class LivroFilter {
    private String titulo;
    private Integer categoria;
    private Double valorMinimo;
    private Double valorMaximo;
    private Boolean disponivel;
}

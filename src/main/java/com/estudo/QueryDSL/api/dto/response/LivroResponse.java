package com.estudo.QueryDSL.api.dto.response;

import lombok.Data;

@Data
public class LivroResponse {
    private Integer idLivro;
    private String titulo;
    private Double valor;
}

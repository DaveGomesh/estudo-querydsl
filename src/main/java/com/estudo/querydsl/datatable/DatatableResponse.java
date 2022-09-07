package com.estudo.querydsl.datatable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DatatableResponse<T> {

    @JsonProperty("draw")
    private Integer draw;
    
    @JsonProperty("recordsTotal")
    private Integer recordsTotal;

    @JsonProperty("recordsFiltered")
    private Integer recordsFiltered;
    
    @JsonProperty("data")
    private List<T> data;
    
    @JsonProperty("error")
    private String error;
}

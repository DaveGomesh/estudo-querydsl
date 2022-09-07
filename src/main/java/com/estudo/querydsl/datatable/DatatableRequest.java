package com.estudo.querydsl.datatable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DatatableRequest {

    @JsonProperty("draw")
    private Integer draw;
    
    @JsonProperty("start")
    private Integer start;
    
    @JsonProperty("length")
    private Integer length;

    @JsonProperty("search")
    private Search search;

    @JsonProperty("order")
    private List<Order> order;

    @JsonProperty("columns")
    private List<Column> columns;
}

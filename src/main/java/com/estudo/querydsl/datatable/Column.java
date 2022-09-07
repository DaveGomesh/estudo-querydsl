package com.estudo.querydsl.datatable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Column {

    @JsonProperty("data")
    private String data;

    @JsonProperty("name")
    private String name;

    @JsonProperty("searchable")
    private Boolean searchable;

    @JsonProperty("orderable")
    private Boolean orderable;

    @JsonProperty("search")
    private Search search;
}

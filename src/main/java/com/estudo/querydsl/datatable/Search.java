package com.estudo.querydsl.datatable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Search {

    @JsonProperty("value")
    private String value;

    @JsonProperty("regex")
    private Boolean regex;
}

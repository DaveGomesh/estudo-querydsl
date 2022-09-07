package com.estudo.querydsl.datatable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Order {

    @JsonProperty("column")
    private Integer column;

    @JsonProperty("dir")
    private String dir;
}

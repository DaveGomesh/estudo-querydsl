package com.estudo.querydsl.filter2;

import java.util.List;

import com.estudo.querydsl.filter2.options.NumberFilterOption;
import com.querydsl.core.types.dsl.NumberPath;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IntegerFilter extends Filter {
    
    private List<Integer> numbers;
    private NumberFilterOption numberFilterOption;
    private NumberPath<Integer> numberPath;
}

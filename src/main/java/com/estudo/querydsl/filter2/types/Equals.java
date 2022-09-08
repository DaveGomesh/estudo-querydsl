package com.estudo.querydsl.filter2.types;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.SimpleExpression;

import lombok.Data;

@Data
public class Equals<T> implements EqualsFilter {

    private final List<T> values;
    private final SimpleExpression<T> valuePath;

    @Override
    public Predicate isEquals() {
        final T value = values.get(0);
        return valuePath.eq(value);
    }

    @Override
    public Predicate isEqualsAny() {
        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        values.forEach(value -> {
            booleanBuilder.or(valuePath.eq(value));
        });
        
        return booleanBuilder;
    }
    
    @Override
    public Predicate isEqualsAll() {
        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        values.forEach(value -> {
            booleanBuilder.and(valuePath.eq(value));
        });
    
        return booleanBuilder;
    }
}

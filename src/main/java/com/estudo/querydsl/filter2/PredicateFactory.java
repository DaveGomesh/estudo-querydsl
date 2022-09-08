package com.estudo.querydsl.filter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.querydsl.core.types.Predicate;

public class PredicateFactory {

    public Predicate createPredicate(Filter filter){

        PathFilter pathFilter = null;

        if(filter instanceof IntegerFilter){
            final IntegerFilter integerFilter = (IntegerFilter) filter;
            pathFilter = new IntegerPathFilter(integerFilter);
        }
        
        final Predicate predicate = pathFilter.applyFilter();
        return predicate;
    }

    public List<Predicate> createPredicate(Filter ...filters){

        final List<Predicate> predicates = new ArrayList<>();
        for(Filter filter : filters){
            predicates.add(createPredicate(filter));
        }

        return predicates;
    }

    public List<Predicate> createPredicate(List<Filter> filters){
        return (
            filters.stream()
            .map(this::createPredicate)
            .collect(Collectors.toList())
        );
    }
}

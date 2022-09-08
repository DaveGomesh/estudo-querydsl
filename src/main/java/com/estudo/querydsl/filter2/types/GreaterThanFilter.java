package com.estudo.querydsl.filter2.types;

import com.querydsl.core.types.Predicate;

public interface GreaterThanFilter {
    
    Predicate isGreaterThan();
    Predicate isGreaterOrEquals();

    Predicate isGreaterThanAny();
    Predicate isGreaterOrEqualsAny();

    Predicate isGreaterThanAll();
    Predicate isGreaterOrEqualsAll();
}

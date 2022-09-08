package com.estudo.querydsl.filter2.types;

import com.querydsl.core.types.Predicate;

public interface LessThanFilter {
    
    Predicate isLessThan();
    Predicate isLessOrEquals();

    Predicate isLessThanAny();
    Predicate isLessOrEqualsAny();

    Predicate isLessThanAll();
    Predicate isLessOrEqualsAll();
}

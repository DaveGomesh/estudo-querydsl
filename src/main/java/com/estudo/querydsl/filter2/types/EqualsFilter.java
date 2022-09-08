package com.estudo.querydsl.filter2.types;

import com.querydsl.core.types.Predicate;

public interface EqualsFilter {
    public Predicate isEquals();
    public Predicate isEqualsAny();
    public Predicate isEqualsAll();
}

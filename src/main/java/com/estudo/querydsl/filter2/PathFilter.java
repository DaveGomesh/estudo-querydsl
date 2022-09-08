package com.estudo.querydsl.filter2;

import com.querydsl.core.types.Predicate;

public interface PathFilter {
    Predicate applyFilter();
}

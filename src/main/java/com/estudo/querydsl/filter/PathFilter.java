package com.estudo.querydsl.filter;

import com.querydsl.core.types.Predicate;

public interface PathFilter {
    
    Predicate applyFilter();
}

package com.estudo.querydsl.filter2.options;

public enum NumberFilterOption {
    // Simple Comparison
    EQUALS,
    GREATER_THAN,
    LESS_THAN,
    GREATER_OR_EQUALS,
    LESS_OR_EQUALS,
    
    // Comparison with "ANY"
    EQUALS_ANY,
    GREATER_THAN_ANY,
    LESS_THAN_ANY,
    GREATER_OR_EQUALS_ANY,
    LESS_OR_EQUALS_ANY,
    
    // Comparison with "ALL"
    EQUALS_ALL,
    GREATER_THAN_ALL,
    LESS_THAN_ALL,
    GREATER_OR_EQUALS_ALL,
    LESS_OR_EQUALS_ALL;
}

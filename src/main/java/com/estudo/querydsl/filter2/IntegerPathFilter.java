package com.estudo.querydsl.filter2;

import java.util.Objects;

import com.estudo.querydsl.filter2.types.Equals;
import com.estudo.querydsl.filter2.types.NumberFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import lombok.Data;

@Data
public class IntegerPathFilter implements PathFilter, NumberFilter {

    private final IntegerFilter integerFilter;
    private final Equals<Integer> equals;

    public IntegerPathFilter(IntegerFilter integerFilter){
        this.integerFilter = integerFilter;
        this.equals = new Equals<>(
            integerFilter.getNumbers(), 
            integerFilter.getNumberPath()
        );
    }

    @Override
    public Predicate applyFilter() {

        Predicate predicate = null;
        switch(integerFilter.getNumberFilterOption()){
            // Simple Comparison
            case EQUALS: predicate = isEquals(); break;
            case GREATER_THAN: predicate = isGreaterThan(); break;
            case LESS_THAN: predicate = isLessThan(); break;
            case GREATER_OR_EQUALS: predicate = isGreaterOrEquals(); break;
            case LESS_OR_EQUALS: predicate = isLessOrEquals(); break;

            // Comparison with "ANY"
            case EQUALS_ANY: predicate = isEqualsAny(); break;
            case GREATER_THAN_ANY: predicate = isGreaterThanAny(); break;
            case LESS_THAN_ANY: predicate = isLessThanAny(); break;
            case GREATER_OR_EQUALS_ANY: predicate = isGreaterOrEqualsAny(); break;
            case LESS_OR_EQUALS_ANY: predicate = isLessOrEqualsAny(); break;

            // Comparison with "ALL"
            case EQUALS_ALL: predicate = isEqualsAll(); break;
            case GREATER_THAN_ALL: predicate = isGreaterThanAll(); break;
            case LESS_THAN_ALL: predicate = isLessThanAll(); break;
            case GREATER_OR_EQUALS_ALL: predicate = isGreaterOrEqualsAll(); break;
            case LESS_OR_EQUALS_ALL: predicate = isLessOrEqualsAll(); break;
        }

        if(needToDeny()){
            predicate = denyExpression(predicate);
        }

        return predicate;
    }

    // Simple Comparison
    @Override
    public Predicate isEquals() {
        return equals.isEquals();
    }

    @Override
    public Predicate isGreaterThan(){
        final Integer number = integerFilter.getNumbers().get(0);
        return integerFilter.getNumberPath().gt(number);
    }

    @Override
    public Predicate isLessThan(){
        final Integer number = integerFilter.getNumbers().get(0);
        return integerFilter.getNumberPath().lt(number);
    }

    @Override
    public Predicate isGreaterOrEquals(){
        final Integer number = integerFilter.getNumbers().get(0);
        return integerFilter.getNumberPath().goe(number);
    }

    @Override
    public Predicate isLessOrEquals(){
        final Integer number = integerFilter.getNumbers().get(0);
        return integerFilter.getNumberPath().loe(number);
    }

    // Comparison with "ANY"
    @Override
    public Predicate isEqualsAny() {
        return equals.isEqualsAny();
    }

    @Override
    public Predicate isGreaterThanAny(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.or(integerFilter.getNumberPath().gt(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isLessThanAny(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.or(integerFilter.getNumberPath().lt(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isGreaterOrEqualsAny(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.or(integerFilter.getNumberPath().goe(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isLessOrEqualsAny(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.or(integerFilter.getNumberPath().loe(number));
        });
        return booleanBuilder;
    }

    // Comparison with "ALL"
    @Override
    public Predicate isEqualsAll() {
        return equals.isEqualsAll();
    }

    @Override
    public Predicate isGreaterThanAll(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.and(integerFilter.getNumberPath().gt(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isLessThanAll(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.and(integerFilter.getNumberPath().lt(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isGreaterOrEqualsAll(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.and(integerFilter.getNumberPath().goe(number));
        });
        return booleanBuilder;
    }

    @Override
    public Predicate isLessOrEqualsAll(){

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        integerFilter.getNumbers().forEach(number -> {
            booleanBuilder.and(integerFilter.getNumberPath().loe(number));
        });
        return booleanBuilder;
    }

    // Checks if the expression should be negated
    private Boolean needToDeny(){
        
        final Boolean denial = integerFilter.getDenial();
        return Objects.nonNull(denial) ? denial : false;
    }

    // deny the expression
    private Predicate denyExpression(Predicate predicate){
        return predicate.not();
    }
}

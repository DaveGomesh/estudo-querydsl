package com.estudo.querydsl.filter;

import java.util.List;
import java.util.Objects;

import com.estudo.querydsl.filter.options.NumberFilterOption;
import com.estudo.querydsl.filter.options.OperatorOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author David Gomesh
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IntegerFilter extends Filter {

    private List<Integer> numbers;
    private NumberFilterOption numberFilterOption;

    public Predicate applyFilter(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        Predicate predicate = null;
        switch(numberFilterOption){
            // Simple Comparison
            case EQUALS: predicate = isEquals(numberPath); break;
            case GREATER_THAN: predicate = isGreaterThan(numberPath); break;
            case LESS_THAN: predicate = isLessThan(numberPath); break;
            case GREATER_OR_EQUALS: predicate = isGreaterOrEquals(numberPath); break;
            case LESS_OR_EQUALS: predicate = isLessOrEquals(numberPath); break;

            // Comparison with "ANY"
            case EQUALS_ANY: predicate = isEqualsAny(numberPath); break;
            case GREATER_THAN_ANY: predicate = isGreaterThanAny(numberPath); break;
            case LESS_THAN_ANY: predicate = isLessThanAny(numberPath); break;
            case GREATER_OR_EQUALS_ANY: predicate = isGreaterOrEqualsAny(numberPath); break;
            case LESS_OR_EQUALS_ANY: predicate = isLessOrEqualsAny(numberPath); break;

            // Comparison with "ALL"
            case EQUALS_ALL: predicate = isEqualsAll(numberPath); break;
            case GREATER_THAN_ALL: predicate = isGreaterThanAll(numberPath); break;
            case LESS_THAN_ALL: predicate = isLessThanAll(numberPath); break;
            case GREATER_OR_EQUALS_ALL: predicate = isGreaterOrEqualsAll(numberPath); break;
            case LESS_OR_EQUALS_ALL: predicate = isLessOrEqualsAll(numberPath); break;
        }

        if(needToDeny()){
            predicate = denyExpression(predicate);
        }

        return predicate;
    }

    // Simple Comparison
    private Predicate isEquals(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.eq(number);

        return booleanExpression;
    }

    private Predicate isGreaterThan(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.gt(number);

        return booleanExpression;
    }

    private Predicate isLessThan(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.lt(number);

        return booleanExpression;
    }

    private Predicate isGreaterOrEquals(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.goe(number);

        return booleanExpression;
    }

    private Predicate isLessOrEquals(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.loe(number);

        return booleanExpression;
    }

    // Comparison with "ANY"
    private Predicate isEqualsAny(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.eq(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterThanAny(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.gt(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isLessThanAny(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.lt(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterOrEqualsAny(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.goe(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isLessOrEqualsAny(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.loe(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    // // Comparison with "ALL"
    private Predicate isEqualsAll(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.eq(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterThanAll(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.gt(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isLessThanAll(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.lt(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterOrEqualsAll(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.goe(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isLessOrEqualsAll(NumberPath<Integer> numberPath){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.loe(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    // Checks if the expression should be negated
    private Boolean needToDeny(){

        final Boolean denial = this.getDenial();
        return Objects.nonNull(denial) ? denial : false;
    }

    // deny the expression
    private Predicate denyExpression(Predicate predicate){
        return predicate.not();
    }

    // Checks if the list is empty
    private void listIsEmpty(){
        if(this.numbers.isEmpty()){
            throw new RuntimeException("Numbers list must contain at least one number.");
        }
    }
}

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
    private NumberPath<Integer> numberPath;

    @Override
    public Predicate applyFilter() {
        this.listIsEmpty();

        Predicate predicate = null;
        switch(numberFilterOption){
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
    private Predicate isEquals(){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.eq(number);

        return booleanExpression;
    }

    private Predicate isGreaterThan(){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.gt(number);

        return booleanExpression;
    }

    private Predicate isLessThan(){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.lt(number);

        return booleanExpression;
    }

    private Predicate isGreaterOrEquals(){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.goe(number);

        return booleanExpression;
    }

    private Predicate isLessOrEquals(){
        this.listIsEmpty();

        final Integer number = numbers.get(0);
        final BooleanExpression booleanExpression = numberPath.loe(number);

        return booleanExpression;
    }

    // Comparison with "ANY"
    private Predicate isEqualsAny(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.eq(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterThanAny(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.gt(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isLessThanAny(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.lt(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterOrEqualsAny(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.goe(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    private Predicate isLessOrEqualsAny(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.loe(number), booleanBuilder, OperatorOption.OR);
        });

        return booleanBuilder;
    }

    // // Comparison with "ALL"
    private Predicate isEqualsAll(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.eq(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterThanAll(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.gt(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isLessThanAll(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.lt(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isGreaterOrEqualsAll(){
        this.listIsEmpty();

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        this.numbers.forEach(number -> {
            this.createComparison(numberPath.goe(number), booleanBuilder, OperatorOption.AND);
        });

        return booleanBuilder;
    }

    private Predicate isLessOrEqualsAll(){
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

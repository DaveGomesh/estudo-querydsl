package com.estudo.querydsl.filter;

import java.util.Objects;

import com.estudo.querydsl.filter.options.OperatorOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.Data;

@Data
public abstract class Filter implements PathFilter {
    private OperatorOption operatorOption;
    private Boolean denial;

    protected BooleanBuilder createComparison(
        BooleanExpression booleanExpression, BooleanBuilder booleanBuilder){

        OperatorOption operatorOption = this.operatorOption;
        if(Objects.isNull(operatorOption)){
            operatorOption = OperatorOption.AND;
        }

        return createComparison(booleanExpression, booleanBuilder, operatorOption);
    }

    protected BooleanBuilder createComparison(
        BooleanExpression booleanExpression, BooleanBuilder booleanBuilder, 
        OperatorOption operatorOption){

        return (
            operatorOption.equals(OperatorOption.AND) ? 
            booleanBuilder.and(booleanExpression) : 
            booleanBuilder.or(booleanExpression)
        );
    }
}

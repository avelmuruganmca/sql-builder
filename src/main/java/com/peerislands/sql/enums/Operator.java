package com.peerislands.sql.enums;

import java.util.Arrays;
import java.util.Optional;

//
// IN, LIKE, =, <=, >= , <>, BETWEEN etc)
public enum Operator {

    EQUAL("Equal","="),
    LIKE("Like","like"),
    NOT_LIKE("NotLike","not like"),
    IN("In","in"),
    NOT_IN("NotIn","not in"),
    LTE("lte","<="),
    GTE("gte",">="),
    NOT_EQUAL("NotEqual","<>"),
    BETWEEN("Between","between");

    private String operator;
    private String symbol;

    Operator(String operator, String symbol) {
        this.operator = operator;
        this.symbol = symbol;
    }

    public String getOperator() {
        return operator;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator findByOperator(String operator){
        Optional<Operator> optionalOperator = Arrays.stream(Operator.values()).filter(operator1 -> operator1.getOperator().equals(operator)).findAny();
        if(optionalOperator.isPresent())
            return optionalOperator.get();
        return null;
    }

}

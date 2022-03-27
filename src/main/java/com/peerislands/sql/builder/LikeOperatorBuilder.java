package com.peerislands.sql.builder;

import com.peerislands.sql.enums.Operator;

import java.util.List;

public class LikeOperatorBuilder implements OperatorBuilder{

    @Override
    public String prepareOperatorCondition(Operator operator, List<Object> value) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(operator.getSymbol());
        sb.append(" ");
        sb.append("'%");
        sb.append(value.get(0));
        sb.append("%'");
        sb.append(" ");
        return sb.toString();
    }
}

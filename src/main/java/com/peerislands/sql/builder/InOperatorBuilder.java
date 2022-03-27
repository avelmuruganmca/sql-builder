package com.peerislands.sql.builder;

import com.peerislands.sql.enums.Operator;

import java.util.List;

public class InOperatorBuilder implements OperatorBuilder{
    @Override
    public String prepareOperatorCondition(Operator operator, List<Object> value) {
        boolean isStringObject = value.get(0) instanceof String;

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(operator.getSymbol());
        sb.append("(");
        if(isStringObject) {
            sb.append("'");
            value.stream().forEach(o -> sb.append(o).append("','"));
            sb.delete(sb.lastIndexOf("','"), sb.length() - 1);
            sb.append("'");
        }else{
            value.stream().forEach(o -> sb.append(o).append(","));
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
            sb.append(")");
        return sb.toString();
    }
}

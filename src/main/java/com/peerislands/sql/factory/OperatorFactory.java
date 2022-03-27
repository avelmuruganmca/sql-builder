package com.peerislands.sql.factory;

import com.peerislands.sql.builder.BetweenOperatorBuilder;
import com.peerislands.sql.builder.DefaultOperatorBuilder;
import com.peerislands.sql.builder.InOperatorBuilder;
import com.peerislands.sql.builder.LikeOperatorBuilder;
import com.peerislands.sql.builder.OperatorBuilder;
import com.peerislands.sql.enums.Operator;

public class OperatorFactory {
    public static OperatorBuilder getOperatorBuilder(Operator operator){
        if(operator.getOperator().equals(Operator.IN.getOperator()) || operator.getOperator().equals(Operator.NOT_IN.getOperator()) ){
            return new InOperatorBuilder();
        }else if(operator.getOperator().equals(Operator.BETWEEN.getOperator())){
            return new BetweenOperatorBuilder();
        }else if(operator.getOperator().equals(Operator.LIKE.getOperator()) || operator.getOperator().equals(Operator.NOT_LIKE.getOperator())){
            return new LikeOperatorBuilder();
        }
        return new DefaultOperatorBuilder();
    }
}

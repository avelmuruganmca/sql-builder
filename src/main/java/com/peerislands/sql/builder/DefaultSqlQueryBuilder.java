package com.peerislands.sql.builder;

import com.peerislands.sql.enums.Operator;
import com.peerislands.sql.factory.OperatorFactory;
import com.peerislands.sql.model.ConditionAny;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public abstract class DefaultSqlQueryBuilder {

    protected String prepareSelectClause(List<String> selectColumns){
        return new StringBuilder("select ")
                .append(String.join(",",selectColumns))
                .toString();
    }
    protected String prepareFromClause(String tableTame){
        return new StringBuilder(" from ")
                .append(tableTame)
                .toString();
    }

    protected String prepareWhereClause(List<ConditionAny> anyList){
        if(CollectionUtils.isEmpty(anyList)){
            return "";
        }
        StringBuilder sb = new StringBuilder(" where (");
        anyList.stream().forEach(conditionAny -> {
            conditionAny.getColumns().stream().forEach(column -> {
                sb.append(column.getFieldName());
                Operator operator = Operator.findByOperator(column.getOperator());
                sb.append(OperatorFactory
                                  .getOperatorBuilder(operator)
                                  .prepareOperatorCondition(operator,column.getFieldValue()));

            });
            sb.append(" or ");
        });
        sb.append(")");
        return sb.toString();
    }
}

package com.peerislands.sql.builder;

import com.peerislands.sql.model.SqlModel;

public class SimpleSqlBuilder extends DefaultSqlQueryBuilder implements SqlBuilder{

    @Override
    public String prepareQuery(SqlModel sqlModel) {

        StringBuilder sb = new StringBuilder();
        sb.append(prepareSelectClause(sqlModel.getSelect()));
        sb.append(prepareFromClause(sqlModel.getTableName()));
        sb.append(prepareWhereClause(sqlModel.getConditionAny()));
        return sb.toString();
    }
}

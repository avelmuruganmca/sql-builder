package com.peerislands.sql.builder;

import com.peerislands.sql.model.SqlModel;

public interface SqlBuilder {
    String prepareQuery(SqlModel sqlModel);
}

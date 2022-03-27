package com.peerislands.sql.manager;

import com.google.gson.Gson;
import com.peerislands.sql.builder.SimpleSqlBuilder;
import com.peerislands.sql.builder.SqlBuilder;
import com.peerislands.sql.model.SqlModel;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class QueryManager {

    public void prepareQuery() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("config.json");
        String result = IOUtils.toString(is, StandardCharsets.UTF_8);
        SqlModel sqlModel = new Gson().fromJson(result, SqlModel.class);

        SqlBuilder sqlBuilder = new SimpleSqlBuilder();
        String finalQuery = sqlBuilder.prepareQuery(sqlModel);
        System.out.println(finalQuery);
    }
}

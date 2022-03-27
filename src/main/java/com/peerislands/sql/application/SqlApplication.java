package com.peerislands.sql.application;


import com.peerislands.sql.manager.QueryManager;

import java.io.IOException;

public class SqlApplication {
    public static void main(String[] args) throws IOException {
        new QueryManager().prepareQuery();
    }
}

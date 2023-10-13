package org.example;

import org.example.config.Database;
import org.example.utils.sql.Query;
import org.example.utils.sql.QueryExecutorService;
import org.example.utils.sql.QueryReader;

import java.util.List;

public class DatabaseInitService {
    public static void main(String[] args) {
        List<Query> queryList = QueryReader.loadQueriesFrom("init_db.sql");

        for (Query q : queryList) {
            QueryExecutorService.executeUpdate(q);
        }

        Database.getInstance().closeConnection();
    }
}

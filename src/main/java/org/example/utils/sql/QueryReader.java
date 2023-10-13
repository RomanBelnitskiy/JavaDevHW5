package org.example.utils.sql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryReader {
    public static List<Query> loadQueriesFrom(String fileName) {
        try {
            String content = Files.readString(Path.of("sql", fileName));
            String[] queryStrings = content.split(";\\r?\\n?");
            return Arrays.stream(queryStrings)
                    .map(String::trim)
                    .map(QueryReader::createQuery)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Query createQuery(String sql) {
        QueryType type;
        if (sql.startsWith("SELECT")) {
            type = QueryType.SELECT;
        } else {
            type = QueryType.UPDATE;
        }

        return new Query(sql, type);
    }
}

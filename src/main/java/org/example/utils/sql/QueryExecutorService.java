package org.example.utils.sql;

import org.example.config.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryExecutorService {
    public static int executeUpdate(Query query) {
        if (query.type() != QueryType.UPDATE) {
            return 0;
        }

        try (Statement statement = Database.getConnection().createStatement()) {
            return statement.executeUpdate(query.sql());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  <T> List<T> executeSelect(Query query, ResultSetMapper<List<T>> mapper) {
        if (query.type() != QueryType.SELECT) {
            return null;
        }

        try (Statement statement = Database.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query.sql());
            List<T> result = mapper.apply(resultSet);
            resultSet.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

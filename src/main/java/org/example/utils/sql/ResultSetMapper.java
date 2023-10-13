package org.example.utils.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {
    T apply(ResultSet rs) throws SQLException;
}

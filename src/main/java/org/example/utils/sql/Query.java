package org.example.utils.sql;

public record Query(String sql, QueryType type) {
    @Override
    public String toString() {
        return sql;
    }
}

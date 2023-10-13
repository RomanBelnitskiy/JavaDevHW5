package org.example.config;

import org.example.utils.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection connection;

    private Database() {
        try {
            String url = PropertyReader.getConnectionUrlForH2();
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw new RuntimeException("Can not create connection");
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return INSTANCE.connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

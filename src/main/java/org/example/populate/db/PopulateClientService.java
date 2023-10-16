package org.example.populate.db;

import org.example.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateClientService {
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client(ID, NAME) VALUES (?, ?)";

    private PreparedStatement insertStatement;

    public PopulateClientService(Connection connection) {
        try {
            insertStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertClient(Client client) {
        try {
            insertStatement.setLong(1, client.getId());
            insertStatement.setString(2, client.getName());

            return insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

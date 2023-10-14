package org.example.populate.db;

import org.example.config.Database;
import org.example.model.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PopulateClientService {
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client(ID, NAME) VALUES (?, ?)";

    public static void insertClientData() {
        List<Client> clients = clientData();

        try(PreparedStatement preparedStatement = Database.getConnection().prepareStatement(INSERT_CLIENT_SQL)) {
            for (Client client : clients) {
                preparedStatement.setLong(1, client.getId());
                preparedStatement.setString(2, client.getName());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Client> clientData() {
        return List.of(
                new Client(1, "Apple"),
                new Client(2, "Microsoft"),
                new Client(3, "Alphabet"),
                new Client(4, "Amazon"),
                new Client(5, "Nvidia"),
                new Client(6, "Tesla")
        );
    }
}

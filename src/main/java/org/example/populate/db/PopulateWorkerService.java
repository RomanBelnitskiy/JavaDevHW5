package org.example.populate.db;

import org.example.model.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateWorkerService {
    private static final String INSERT_WORKER_SQL = "INSERT INTO worker(ID, NAME, BIRTHDAY, LEVEL, SALARY) " +
            "VALUES(?, ?, ?, ?, ?)";

    private PreparedStatement insertStatement;

    public PopulateWorkerService(Connection connection) {
        try {
            insertStatement = connection.prepareStatement(INSERT_WORKER_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertWorker(Worker worker) {
        try {
            insertStatement.setLong(1, worker.getId());
            insertStatement.setString(2, worker.getName());
            insertStatement.setDate(3, Date.valueOf(worker.getBirthday()));
            insertStatement.setString(4, worker.getLevel().toString());
            insertStatement.setInt(5, worker.getSalary());

            return insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

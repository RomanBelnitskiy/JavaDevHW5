package org.example.populate.db;

import org.example.model.ProjectWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateProjectWorkerService {
    private static final String INSERT_PROJECT_WORKER_SQL = "INSERT INTO project_worker(PROJECT_ID, WORKER_ID) " +
            "VALUES (?, ?)";

    private PreparedStatement insertStatement;

    public PopulateProjectWorkerService(Connection connection) {
        try {
            insertStatement = connection.prepareStatement(INSERT_PROJECT_WORKER_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertProjectWorker(ProjectWorker projectWorker) {
        try {
            insertStatement.setLong(1, projectWorker.getProjectId());
            insertStatement.setLong(2, projectWorker.getWorkerId());

            return insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

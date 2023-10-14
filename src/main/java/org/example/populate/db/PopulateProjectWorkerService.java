package org.example.populate.db;

import org.example.config.Database;
import org.example.model.ProjectWorker;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PopulateProjectWorkerService {
    private static final String INSERT_PROJECT_WORKER_SQL = "INSERT INTO project_worker(PROJECT_ID, WORKER_ID) " +
            "VALUES (?, ?)";

    public static void insertProjectWorkerData() {
        List<ProjectWorker> projectWorkerList = projectWorkerData();

        try(PreparedStatement preparedStatement = Database.getConnection().prepareStatement(INSERT_PROJECT_WORKER_SQL)) {
            for (ProjectWorker pw : projectWorkerList) {
                preparedStatement.setLong(1, pw.getProjectId());
                preparedStatement.setLong(2, pw.getWorkerId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<ProjectWorker> projectWorkerData() {
        return List.of(
                new ProjectWorker(1, 3),
                new ProjectWorker(1, 2),
                new ProjectWorker(1, 4),
                new ProjectWorker(1, 9),
                new ProjectWorker(2, 5),
                new ProjectWorker(2, 8),
                new ProjectWorker(2, 9),
                new ProjectWorker(2, 10),
                new ProjectWorker(2, 11),
                new ProjectWorker(3, 1),
                new ProjectWorker(3, 6),
                new ProjectWorker(3, 7),
                new ProjectWorker(4, 3),
                new ProjectWorker(4, 2),
                new ProjectWorker(4, 4),
                new ProjectWorker(4, 8),
                new ProjectWorker(5, 5),
                new ProjectWorker(5, 9),
                new ProjectWorker(5, 10),
                new ProjectWorker(5, 11),
                new ProjectWorker(6, 8),
                new ProjectWorker(6, 1),
                new ProjectWorker(6, 6),
                new ProjectWorker(7, 5),
                new ProjectWorker(7, 10),
                new ProjectWorker(8, 3),
                new ProjectWorker(8, 2),
                new ProjectWorker(8, 4),
                new ProjectWorker(8, 9),
                new ProjectWorker(9, 11),
                new ProjectWorker(9, 1),
                new ProjectWorker(9, 6),
                new ProjectWorker(9, 5),
                new ProjectWorker(10, 10),
                new ProjectWorker(10, 3),
                new ProjectWorker(11, 7),
                new ProjectWorker(11, 9),
                new ProjectWorker(11, 8),
                new ProjectWorker(12, 5),
                new ProjectWorker(12, 4),
                new ProjectWorker(13, 6),
                new ProjectWorker(13, 1),
                new ProjectWorker(13, 3)
        );
    }
}

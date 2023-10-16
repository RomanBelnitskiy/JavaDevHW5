package org.example.populate.db;

import org.example.model.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateProjectService {
    private static final String INSERT_PROJECT_SQL = "INSERT INTO project(ID, CLIENT_ID, NAME, START_DATE, FINISH_DATE) " +
            "VALUES (?, ?, ?, ?, ?)";

    private PreparedStatement insertStatement;

    public PopulateProjectService(Connection connection) {
        try {
            insertStatement = connection.prepareStatement(INSERT_PROJECT_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertProject(Project project) {
        try {
            insertStatement.setLong(1, project.getId());
            insertStatement.setLong(2, project.getClientId());
            insertStatement.setString(3, project.getName());
            insertStatement.setDate(4, Date.valueOf(project.getStartDate()));
            Date finishDate = project.getFinishDate() != null ? Date.valueOf(project.getFinishDate()) : null;
            insertStatement.setDate(5, finishDate);

            return insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.populate.db;

import org.example.config.Database;
import org.example.model.Project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PopulateProjectService {
    private static final String INSERT_PROJECT_SQL = "INSERT INTO project(ID, CLIENT_ID, NAME, START_DATE, FINISH_DATE) " +
            "VALUES (?, ?, ?, ?, ?)";

    public static void insertProjectData() {
        List<Project> projects = projectData();

        try(PreparedStatement preparedStatement = Database.getConnection().prepareStatement(INSERT_PROJECT_SQL)) {
            for (Project project : projects) {
                preparedStatement.setLong(1, project.getId());
                preparedStatement.setLong(2, project.getClientId());
                preparedStatement.setString(3, project.getName());
                preparedStatement.setDate(4, Date.valueOf(project.getStartDate()));
                Date finishDate = project.getFinishDate() != null ? Date.valueOf(project.getFinishDate()) : null;
                preparedStatement.setDate(5, finishDate);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Project> projectData() {
        return List.of(
                new Project(1, 2, "Project 1", LocalDate.of(2020,12,1), LocalDate.of(2021,5,12)),
                new Project(2, 1, "Project 2", LocalDate.of(2021,5,18), LocalDate.of(2023,8,01)),
                new Project(3, 2, "Project 3", LocalDate.of(2021,1,4), LocalDate.of(2022,7,1)),
                new Project(4, 3, "Project 4", LocalDate.of(2021,5,15), LocalDate.of(2023,1,1)),
                new Project(5, 4, "Project 5", LocalDate.of(2021,9,1), LocalDate.of(2023,6,24)),
                new Project(6, 5, "Project 6", LocalDate.of(2021,12,10), LocalDate.of(2023,2,8)),
                new Project(7, 6, "Project 7", LocalDate.of(2022,2,13), LocalDate.of(2023,9,13)),
                new Project(8, 1, "Project 8", LocalDate.of(2022,5,20), null),
                new Project(9, 4, "Project 9", LocalDate.of(2022,8,6), LocalDate.of(2023,2,25)),
                new Project(10, 6, "Project A", LocalDate.of(2022,11,19), null),
                new Project(11, 5, "Project B", LocalDate.of(2023,1,23), LocalDate.of(2023,4,22)),
                new Project(12, 3, "Project C", LocalDate.of(2023,4,1), null),
                new Project(13, 1, "Project D", LocalDate.of(2023,7,7), null),
                new Project(14, 4, "Project E", LocalDate.of(2023,8,6), null)
        );
    }
}

package org.example.populate.db;

import org.example.config.Database;
import org.example.model.Level;
import org.example.model.Worker;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PopulateWorkerService {
    private static final String INSERT_WORKER_SQL = "INSERT INTO worker(ID, NAME, BIRTHDAY, LEVEL, SALARY) " +
            "VALUES(?, ?, ?, ?, ?)";

    public static void insertWorkerData() {
        List<Worker> workers = workerData();

        try(PreparedStatement preparedStatement = Database.getConnection().prepareStatement(INSERT_WORKER_SQL)) {
            for (Worker worker : workers) {
                preparedStatement.setLong(1, worker.getId());
                preparedStatement.setString(2, worker.getName());
                preparedStatement.setDate(3, Date.valueOf(worker.getBirthday()));
                preparedStatement.setString(4, worker.getLevel().toString());
                preparedStatement.setInt(5, worker.getSalary());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Worker> workerData() {
        return List.of(
                new Worker(1, "Robert", LocalDate.of(1995,12,20), Level.JUNIOR, 1000),
                new Worker(2, "Bernard", LocalDate.of(1998,1,10), Level.MIDDLE, 5000),
                new Worker(3, "Michle", LocalDate.of(1991,7,22), Level.SENIOR, 10000),
                new Worker(4, "John", LocalDate.of(2001,6,27), Level.MIDDLE, 4500),
                new Worker(5, "Jane", LocalDate.of(2000,11,5), Level.SENIOR, 11000),
                new Worker(6, "Jack", LocalDate.of(1999,10,25), Level.MIDDLE, 3500),
                new Worker(7, "Oliver", LocalDate.of(2003,1,10), Level.JUNIOR, 1000),
                new Worker(8, "Charlie", LocalDate.of(2002,5,1), Level.MIDDLE, 5000),
                new Worker(9, "Oscar", LocalDate.of(1997,3,15), Level.JUNIOR, 1000),
                new Worker(10, "Emily", LocalDate.of(1991,11,24), Level.MIDDLE, 3000),
                new Worker(11, "Olivia", LocalDate.of(1986,2,17), Level.MIDDLE, 4000)
        );
    }
}

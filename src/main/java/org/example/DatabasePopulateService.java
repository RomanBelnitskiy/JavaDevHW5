package org.example;

import org.example.config.Database;
import org.example.model.*;
import org.example.populate.db.PopulateClientService;
import org.example.populate.db.PopulateProjectService;
import org.example.populate.db.PopulateProjectWorkerService;
import org.example.populate.db.PopulateWorkerService;

import java.time.LocalDate;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        insertWorkerData();
        insertClientData();
        insertProjectData();
        insertProjectWorkerData();

        Database.getInstance().closeConnection();
    }

    public static void insertClientData() {
        PopulateClientService pcs = new PopulateClientService(Database.getConnection());
        List<Client> clients = clientData();

        for (Client client : clients) {
            pcs.insertClient(client);
        }
    }

    public static void insertProjectData() {
        PopulateProjectService pps = new PopulateProjectService(Database.getConnection());
        List<Project> projects = projectData();

        for (Project project : projects) {
            pps.insertProject(project);
        }
    }

    public static void insertWorkerData() {
        PopulateWorkerService pws = new PopulateWorkerService(Database.getConnection());
        List<Worker> workers = workerData();

        for (Worker worker : workers) {
            pws.insertWorker(worker);
        }
    }

    public static void insertProjectWorkerData() {
        PopulateProjectWorkerService ppws = new PopulateProjectWorkerService(Database.getConnection());
        List<ProjectWorker> projectWorkerList = projectWorkerData();

        for (ProjectWorker projectWorker : projectWorkerList) {
            ppws.insertProjectWorker(projectWorker);
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

package org.example;

import org.example.config.Database;

import static org.example.populate.db.PopulateClientService.insertClientData;
import static org.example.populate.db.PopulateProjectService.insertProjectData;
import static org.example.populate.db.PopulateProjectWorkerService.insertProjectWorkerData;
import static org.example.populate.db.PopulateWorkerService.insertWorkerData;

public class DatabasePopulateService {
    public static void main(String[] args) {
        insertWorkerData();
        insertClientData();
        insertProjectData();
        insertProjectWorkerData();

        Database.getInstance().closeConnection();
    }
}

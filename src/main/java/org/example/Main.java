package org.example;

import org.example.config.Database;
import org.example.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaxProjectCountClient> clients = DatabaseQueryService.findMaxProjectsClient();
        printList(clients);

        List<MaxSalaryWorker> maxSalaryWorkers = DatabaseQueryService.findMaxSalaryWorker();
        printList(maxSalaryWorkers);

        List<LongestProject> longestProjects = DatabaseQueryService.findLongestProject();
        printList(longestProjects);

        List<YoungestEldestWorker> youngestEldestWorkers = DatabaseQueryService.findYoungestEldestWorkers();
        printList(youngestEldestWorkers);

        List<ProjectPrice> projectPrices = DatabaseQueryService.findProjectPrices();
        printList(projectPrices);

        Database.getInstance().closeConnection();
    }

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
        System.out.println("==============================================");
        System.out.println();
    }
}
package org.example;

import org.example.model.*;
import org.example.utils.sql.Query;
import org.example.utils.sql.QueryExecutorService;
import org.example.utils.sql.QueryReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static List<MaxSalaryWorker> findMaxSalaryWorker() {
        Query query = QueryReader.loadQueriesFrom("find_max_salary_worker.sql").get(0);

        return QueryExecutorService.executeSelect(query, DatabaseQueryService::maxSalaryWorkerMapper);
    }

    private static List<MaxSalaryWorker> maxSalaryWorkerMapper(ResultSet rs) throws SQLException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            int workerSalary = rs.getInt("salary");
            maxSalaryWorkers.add(new MaxSalaryWorker(name, workerSalary));
        }
        return maxSalaryWorkers;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        Query query = QueryReader.loadQueriesFrom("find_max_projects_client.sql").get(0);

        return QueryExecutorService.executeSelect(query, DatabaseQueryService::maxProjectsClientMapper);
    }

    private static List<MaxProjectCountClient> maxProjectsClientMapper(ResultSet rs) throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            int projectCount = rs.getInt("project_count");
            maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
        }

        return maxProjectCountClients;
    }

    public static List<LongestProject> findLongestProject() {
        Query query = QueryReader.loadQueriesFrom("find_longest_project.sql").get(0);

        return QueryExecutorService.executeSelect(query, DatabaseQueryService::longestProjectMapper);
    }

    private static List<LongestProject> longestProjectMapper(ResultSet rs) throws SQLException {
        List<LongestProject> longestProjects = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            int monthCount = rs.getInt("month_count");
            longestProjects.add(new LongestProject(name, monthCount));
        }

        return longestProjects;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorkers() {
        Query query = QueryReader.loadQueriesFrom("find_youngest_eldest_workers.sql").get(0);

        return QueryExecutorService.executeSelect(query, DatabaseQueryService::youngestEldestWorkersMapper);
    }

    private static List<YoungestEldestWorker> youngestEldestWorkersMapper(ResultSet rs) throws SQLException {
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();
        while (rs.next()) {
            String type = rs.getString("type");
            String name = rs.getString("name");
            LocalDate birthday = rs.getDate("birthday").toLocalDate();
            youngestEldestWorkers.add(new YoungestEldestWorker(type, name, birthday));
        }

        return youngestEldestWorkers;
    }

    public static List<ProjectPrice> findProjectPrices() {
        Query query = QueryReader.loadQueriesFrom("print_project_prices.sql").get(0);

        return QueryExecutorService.executeSelect(query, DatabaseQueryService::projectPricesMapper);
    }

    private static List<ProjectPrice> projectPricesMapper(ResultSet rs) throws SQLException {
        List<ProjectPrice> projectPrices = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            projectPrices.add(new ProjectPrice(name, price));
        }

        return projectPrices;
    }
}

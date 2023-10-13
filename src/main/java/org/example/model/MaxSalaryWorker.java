package org.example.model;

public record MaxSalaryWorker(String name, int salary) {
    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

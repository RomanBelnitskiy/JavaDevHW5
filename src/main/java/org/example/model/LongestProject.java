package org.example.model;

public record LongestProject(String name, int monthCount) {
    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}

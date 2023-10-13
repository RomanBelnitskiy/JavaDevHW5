package org.example.model;

public record MaxProjectCountClient(String name, int projectCount) {
    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}

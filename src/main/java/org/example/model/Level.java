package org.example.model;

public enum Level {
    TRAINEE("Trainee"), JUNIOR("Junior"), MIDDLE("Middle"), SENIOR("Senior");

    private String name;

    Level(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

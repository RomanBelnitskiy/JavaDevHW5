package org.example.model;

import java.time.LocalDate;

public record YoungestEldestWorker(String type, String name, LocalDate birthday) {
    @Override
    public String toString() {
        return "YoungestEldestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

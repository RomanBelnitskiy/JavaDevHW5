package org.example.model;

import java.time.LocalDate;

public class Worker {
    private long id;
    private String name;
    private LocalDate birthday;
    private Level level;
    private int salary;

    public Worker() {
    }

    public Worker(long id, String name, LocalDate birthday, Level level, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", level=" + level +
                ", salary=" + salary +
                '}';
    }
}

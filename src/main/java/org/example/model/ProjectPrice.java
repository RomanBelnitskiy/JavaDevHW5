package org.example.model;

public record ProjectPrice(String name, int price) {
    @Override
    public String toString() {
        return "ProjectPrice{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

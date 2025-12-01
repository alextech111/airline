package com.example.airline.model;

public class Passenger {
    private int id;
    private String name;
    private int age;
    private int flightId;

    public Passenger(int id, String name, int age, int flightId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.flightId = flightId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getFlightId() { return flightId; }

    @Override
    public String toString() {
        return String.format("Passenger{id=%d, name='%s', age=%d, flightId=%d}", id, name, age, flightId);
    }
}

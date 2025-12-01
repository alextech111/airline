package com.example.airline.model;

public class Flight {
    private int id;
    private String destination;
    private String date;
    private Airplane airplane;

    public Flight(int id, String destination, String date, Airplane airplane) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.airplane = airplane;
    }

    public int getId() { return id; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public Airplane getAirplane() { return airplane; }

    @Override
    public String toString() {
        return String.format("Flight{id=%d, destination='%s', date='%s', airplane=%s}", id, destination, date, airplane.getModel());
    }
}

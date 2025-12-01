package com.example.airline.model;

public class Airplane {
    private int id;
    private String model;
    private int capacity;

    public Airplane(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("Airplane{id=%d, model='%s', capacity=%d}", id, model, capacity);
    }
}

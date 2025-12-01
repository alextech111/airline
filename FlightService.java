package com.example.airline.service;

import com.example.airline.model.Flight;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    public List<Flight> findByDestination(List<Flight> flights, String dest) {
        if (dest == null) return List.of();
        String target = dest.trim().toLowerCase();
        return flights.stream()
                .filter(f -> f.getDestination() != null && f.getDestination().trim().toLowerCase().contains(target))
                .collect(Collectors.toList());
    }
}

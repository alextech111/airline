package com.example.airline.service;

import com.example.airline.model.Passenger;
import java.util.List;
import java.util.stream.Collectors;

public class PassengerService {
    public List<Passenger> filterByMinAge(List<Passenger> passengers, int minAge) {
        return passengers.stream()
                .filter(p -> p.getAge() >= minAge)
                .collect(Collectors.toList());
    }
}

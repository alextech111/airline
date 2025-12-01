package com.example.airline;

import com.example.airline.model.Airplane;
import com.example.airline.model.Flight;
import com.example.airline.model.Passenger;
import com.example.airline.service.FlightService;
import com.example.airline.service.PassengerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane(1, "Boeing 737", 160));
        airplanes.add(new Airplane(2, "Airbus A320", 150));

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(101, "Moscow", "2025-12-10", airplanes.get(0)));
        flights.add(new Flight(102, "New York", "2025-12-12", airplanes.get(1)));
        flights.add(new Flight(103, "Paris", "2025-12-15", airplanes.get(0)));

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(1, "Ivan Ivanov", 28, 101));
        passengers.add(new Passenger(2, "Anna Petrova", 22, 102));
        passengers.add(new Passenger(3, "John Doe", 17, 103));
        passengers.add(new Passenger(4, "Mary Jane", 45, 101));

        FlightService flightService = new FlightService();
        PassengerService passengerService = new PassengerService();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Airline Service ---");
            System.out.println("1) List all flights");
            System.out.println("2) Search flights by destination");
            System.out.println("3) List all passengers");
            System.out.println("4) Filter passengers by min age");
            System.out.println("5) Show passengers for a flight (by id)");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String line = scanner.nextLine().trim();
            if (line.equals("0")) break;
            switch (line) {
                case "1":
                    flights.forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Destination (substring allowed): ");
                    String dest = scanner.nextLine();
                    var found = flightService.findByDestination(flights, dest);
                    if (found.isEmpty()) System.out.println("No flights found.");
                    else found.forEach(System.out::println);
                    break;
                case "3":
                    passengers.forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Minimum age: ");
                    try {
                        int min = Integer.parseInt(scanner.nextLine().trim());
                        var list = passengerService.filterByMinAge(passengers, min);
                        if (list.isEmpty()) System.out.println("No passengers match the filter.");
                        else list.forEach(System.out::println);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "5":
                    System.out.print("Flight id: ");
                    try {
                        int fid = Integer.parseInt(scanner.nextLine().trim());
                        passengers.stream()
                                .filter(p -> p.getFlightId() == fid)
                                .forEach(System.out::println);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                default:
                    System.out.println("Unknown option.");
            }
        }
        System.out.println("Bye!");
        scanner.close();
    }
}

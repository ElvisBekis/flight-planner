package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.airport.Airport;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FlightRepository {

    Set<Airport> airports = new HashSet<>();

    Set<Flight> flights = new HashSet<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void clearFlights() {
        flights.clear();
    }

    public Set<Airport> getAirports() {
        airports.addAll(flights.stream().flatMap(f -> Stream.of(f.getFrom(), f.getTo())).collect(Collectors.toSet()));
        return airports;

    }

    public void deleteFlight(Long id) {
        flights.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .ifPresent(f -> flights.remove(f));
    }

    public boolean checkForDouble(Flight flight) {
        return flights.stream()
                .anyMatch(flight::isFlightEqual);
    }

    public Optional<Flight> getFlightById(Long id) {
       return flights.stream()
               .filter(f -> f.getId().equals(id))
               .findFirst();
    }
}

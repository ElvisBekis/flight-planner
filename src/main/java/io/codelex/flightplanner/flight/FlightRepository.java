package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.domain.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class FlightRepository {

    private final Set<Flight> flights = new HashSet<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void clearFlights() {
        flights.clear();
    }

    public void deleteFlight(Long id) {
        flights.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .ifPresent(flights::remove);
    }

    public boolean exists(Flight flight) {
        return flights.stream()
                .anyMatch(flight::isFlightEqual);
    }

    public Optional<Flight> getFlightById(Long id) {
       return flights.stream()
               .filter(f -> f.getId().equals(id))
               .findFirst();
    }
}

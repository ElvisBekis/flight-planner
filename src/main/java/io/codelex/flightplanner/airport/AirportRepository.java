package io.codelex.flightplanner.airport;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.flight.FlightRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AirportRepository {

    private final FlightRepository flightRepository;

    private final Set<Airport> airports = new HashSet<>();

    public AirportRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Set<Airport> getAirports() {
        airports.addAll(flightRepository.getFlights().stream().flatMap(f -> Stream.of(f.getFrom(), f.getTo())).collect(Collectors.toSet()));
        return airports;
    }
}

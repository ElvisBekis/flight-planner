package io.codelex.flightplanner.airport;

import io.codelex.flightplanner.domain.Airport;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AirportService {

    AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Set<Airport> searchAirportsByPhrase(String search) {
        return airportRepository.getAirports()
                .stream()
                .filter(airport -> airport.matchesSearchCriteria(search))
                .collect(Collectors.toSet());
    }
}

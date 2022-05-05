package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.api.AddFlightRequest;
import io.codelex.flightplanner.api.SearchFlightRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private Long counter = 0L;

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public synchronized Flight addFlight(AddFlightRequest request) {
        Flight flight = request.toDomain(setFlightId());
        if (flightRepository.exists(flight)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        if (flight.isRouteValid() || flight.isDateValid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        flightRepository.addFlight(flight);
        return flight;
    }

    public synchronized void deleteFlight(Long id) {
        flightRepository.deleteFlight(id);
    }

    public synchronized void clearFlights() {
        flightRepository.clearFlights();
    }

    public synchronized Long setFlightId() {
        counter++;
        return counter;
    }

    public Flight getFlightById(Long id) {
       return flightRepository.getFlightById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Set<Flight> searchFlights(SearchFlightRequest request) {
        if (request.isFromEqualTo()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return flightRepository.getFlights()
                .stream()
                .filter(flight -> flight.isRequestedFlightPresent(request))
                .collect(Collectors.toSet());
    }
}

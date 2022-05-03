package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.airport.AirportService;
import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.requests.SearchFlightRequest;
import io.codelex.flightplanner.requests.SearchFlightReturn;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class FlightUserController {

    private final FlightService flightService;
    private final AirportService airportService;

    public FlightUserController(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    @ResponseBody
    public Set<Airport> searchAirportsByPhrase(@RequestParam String search) {
        return airportService.searchAirportsByPhrase(search);
    }

    @PostMapping("/flights/search")
    @ResponseBody
    public SearchFlightReturn searchFlights(@Valid @RequestBody SearchFlightRequest request) {
            Set<Flight> flightsFound = flightService.searchFlights(request);
        return new SearchFlightReturn(flightsFound, flightsFound.size(), 0);
        }


    @GetMapping(value = "/flights/{id}")
    public Flight getFlight(@PathVariable("id") Long id) {
        return flightService.getFlightById(id);
    }
}

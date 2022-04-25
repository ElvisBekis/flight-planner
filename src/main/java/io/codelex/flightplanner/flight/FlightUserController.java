package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.airport.Airport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class FlightUserController {

    private final FlightService flightService;

    public FlightUserController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/airports")
    @ResponseBody
    public Set<Airport> searchAirportsByPhrase(@RequestParam String search) {
        return flightService.searchAirportsByPhrase(search);
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

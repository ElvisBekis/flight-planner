package io.codelex.flightplanner.flight;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin-api")
public class FlightAdminController {

    private final FlightService flightService;

    public FlightAdminController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping("/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight addFlight(@Valid @RequestBody FlightRequest flightRequest) {
        Flight flight = flightRequest.toDomain(flightService.setFlightId());
        flightService.addFlight(flight);
        return flight;
    }

    @DeleteMapping(value = "/flights/{id}")
    public void deleteFlight(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping(value = "/flights/{id}")
    public Flight getFlight(@PathVariable("id") Long id) {
        return flightService.getFlightById(id);
    }

}

package io.codelex.flightplanner.flight;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api/")
public class FlightTestController {

    private final FlightService flightService;

    public FlightTestController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping("/clear")
    public void clearFlights() {
        flightService.clearFlights();
    }
}

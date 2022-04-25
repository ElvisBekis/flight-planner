package io.codelex.flightplanner.flight;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class SearchFlightRequest {

    @NotNull
    private String fromAirport;

    @NotNull
    private String toAirport;

    @NotNull
    private String departureDate;

    public SearchFlightRequest(String from, String to, String departureDate) {
        this.fromAirport = from;
        this.toAirport = to;
        this.departureDate = departureDate;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isFromEqualTo() {
        return this.fromAirport.equals(this.toAirport);
    }
}

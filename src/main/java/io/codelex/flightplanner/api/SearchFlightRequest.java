package io.codelex.flightplanner.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class SearchFlightRequest {

    @NotNull
    private String fromAirport;

    @NotNull
    private String toAirport;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    public SearchFlightRequest(String from, String to, LocalDate departureDate) {
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isFromEqualTo() {
        return this.fromAirport.equals(this.toAirport);
    }
}

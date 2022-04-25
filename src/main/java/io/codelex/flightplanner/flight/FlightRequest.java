package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.airport.Airport;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Validated
public class FlightRequest {

    @Valid
    @NotNull
    private Airport from;

    @Valid
    @NotNull
    private Airport to;

    @NotNull
    @NotBlank
    private String carrier;

    @NotNull
    private String departureTime;

    @NotNull
    private String arrivalTime;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public FlightRequest(Airport from, Airport to, String carrier, String departureTime, String arrivalTime) {
        this.from = from;
        this.to = to;
        this.carrier = carrier;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight toDomain(Long id) {
        return new Flight(id, from, to, carrier, LocalDateTime.parse(departureTime, formatter), LocalDateTime.parse(arrivalTime, formatter));
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

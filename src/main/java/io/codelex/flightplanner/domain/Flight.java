package io.codelex.flightplanner.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.codelex.flightplanner.api.SearchFlightRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {

    private Long id;
    private Airport from;
    private Airport to;
    private String carrier;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime departureTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime arrivalTime;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Flight(Long id, Airport from, Airport to, String carrier, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.carrier = carrier;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public boolean isFlightEqual(Flight flight) {
        return this.from.equals(flight.from)
                && this.to.equals(flight.to)
                && this.carrier.equals(flight.carrier)
                && this.departureTime.equals(flight.departureTime)
                && this.arrivalTime.equals(flight.arrivalTime);
    }

    public boolean isRouteValid() {
        return from.isEqualAirport(to);
    }

    public boolean isDateValid() {
        return departureTime.compareTo(arrivalTime) >= 0;
    }

    public boolean isRequestedFlightPresent(SearchFlightRequest request) {
        return from.getAirport().equals(request.getFromAirport())
                && to.getAirport().equals(request.getToAirport())
                && departureTime.toLocalDate().equals(request.getDepartureDate());
    }


}


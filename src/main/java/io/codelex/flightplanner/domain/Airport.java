package io.codelex.flightplanner.domain;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Airport {

    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String airport;

    public Airport(String country, String city, String airport) {
        this.country = country;
        this.city = city;
        this.airport = airport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public boolean isEqualAirport(Airport airport) {
        return this.country.trim().equalsIgnoreCase(airport.country.trim())
                && this.city.trim().equalsIgnoreCase(airport.city.trim())
                && this.airport.trim().equalsIgnoreCase(airport.airport.trim());
    }

    public boolean matchesSearchCriteria(String search) {
        return format(airport)
                .contains(format(search))
                || format(city)
                .contains(format(search))
                || format(country)
                .contains(format(search));
    }

    private String format(String string) {
        return string.trim()
                .toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport1 = (Airport) o;
        return country.equals(airport1.country) && city.equals(airport1.city) && airport.equals(airport1.airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, airport);
    }
}
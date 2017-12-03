package com.kodilla.good.patterns.flights.builders;

import com.kodilla.good.patterns.flights.Flight;
import com.kodilla.good.patterns.flights.FlightRoute;

import java.time.LocalDateTime;

public final class FlightBuilder {
    private FlightRoute flightRoute;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    private FlightBuilder() {
    }

    public static FlightBuilder aFlight() {
        return new FlightBuilder();
    }

    public FlightBuilder withFlightRoute(FlightRoute flightRoute) {
        this.flightRoute = flightRoute;
        return this;
    }

    public FlightBuilder withDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
        return this;
    }

    public FlightBuilder withArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
        return this;
    }

    public Flight build() {
        return new Flight(flightRoute, departureDateTime, arrivalDateTime);
    }
}

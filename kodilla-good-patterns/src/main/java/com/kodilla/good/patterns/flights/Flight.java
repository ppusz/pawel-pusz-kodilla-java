package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;

public class Flight {

    private FlightRoute flightRoute;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    public Flight(final FlightRoute flightRoute, final LocalDateTime departureDateTime, final LocalDateTime arrivalDateTime) {
        this.flightRoute = flightRoute;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public FlightRoute getFlightRoute() {
        return flightRoute;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightRoute != null ? !flightRoute.equals(flight.flightRoute) : flight.flightRoute != null) return false;
        if (departureDateTime != null ? !departureDateTime.equals(flight.departureDateTime) : flight.departureDateTime != null)
            return false;
        return arrivalDateTime != null ? arrivalDateTime.equals(flight.arrivalDateTime) : flight.arrivalDateTime == null;
    }

    @Override
    public int hashCode() {
        int result = flightRoute != null ? flightRoute.hashCode() : 0;
        result = 31 * result + (departureDateTime != null ? departureDateTime.hashCode() : 0);
        result = 31 * result + (arrivalDateTime != null ? arrivalDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightRoute=" + flightRoute +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                '}';
    }
}

package com.kodilla.good.patterns.flights;

import java.time.LocalDate;

public class SearchCriteria {

    private Airport departureAirport;
    private Airport destinationAirport;
    private LocalDate date;
    private int minMinutesBetweenFlights = 30;
    private int maxMinutesBetweenFlights = 360;

    public SearchCriteria(final Airport departureAirport, final Airport destinationAirport, final LocalDate date,
                          final int minMinutesBetweenFlights, final int maxMinutesBetweenFlights) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
        this.minMinutesBetweenFlights = minMinutesBetweenFlights;
        this.maxMinutesBetweenFlights = maxMinutesBetweenFlights;
    }

    public SearchCriteria(Airport departureAirport, Airport destinationAirport, LocalDate date) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMinMinutesBetweenFlights() {
        return minMinutesBetweenFlights;
    }

    public int getMaxMinutesBetweenFlights() {
        return maxMinutesBetweenFlights;
    }
}

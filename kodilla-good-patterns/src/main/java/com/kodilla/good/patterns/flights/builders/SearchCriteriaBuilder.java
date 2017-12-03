package com.kodilla.good.patterns.flights.builders;

import com.kodilla.good.patterns.flights.Airport;
import com.kodilla.good.patterns.flights.SearchCriteria;

import java.time.LocalDate;

public final class SearchCriteriaBuilder {
    private Airport departureAirport;
    private Airport destinationAirport;
    private LocalDate date;
    private int minMinutesBetweenFlights = 30;
    private int maxMinutesBetweenFlights = 360;

    private SearchCriteriaBuilder() {
    }

    public static SearchCriteriaBuilder aSearchCriteria() {
        return new SearchCriteriaBuilder();
    }

    public SearchCriteriaBuilder withDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public SearchCriteriaBuilder withDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public SearchCriteriaBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public SearchCriteriaBuilder withMinMinutesBetweenFlights(int minMinutesBetweenFlights) {
        this.minMinutesBetweenFlights = minMinutesBetweenFlights;
        return this;
    }

    public SearchCriteriaBuilder withMaxMinutesBetweenFlights(int maxMinutesBetweenFlights) {
        this.maxMinutesBetweenFlights = maxMinutesBetweenFlights;
        return this;
    }

    public SearchCriteria build() {
        return new SearchCriteria(departureAirport, destinationAirport, date, minMinutesBetweenFlights, maxMinutesBetweenFlights);
    }
}

package com.kodilla.good.patterns.flights.retrievers;

import com.kodilla.good.patterns.flights.Airport;
import com.kodilla.good.patterns.flights.SearchCriteria;
import com.kodilla.good.patterns.flights.builders.SearchCriteriaBuilder;

import java.time.LocalDate;
import java.util.Map;

public class SearchCriteriaRetriever {

    public SearchCriteria retrieve() {

        SearchCriteriaBuilder builder = SearchCriteriaBuilder.aSearchCriteria();
        Map<String, Airport> airports = new AirportsRetriever().retrieve();
        builder.withDepartureAirport(airports.get("POZ"));
        builder.withDestinationAirport(airports.get("RZE"));
        builder.withDate(LocalDate.of(2017,12,24));
        builder.withMinMinutesBetweenFlights(15);

        return builder.build();
    }
}

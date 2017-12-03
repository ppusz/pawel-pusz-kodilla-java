package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.retrievers.FlightsRetriever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DepartureFlightFindingService implements FlightFindingService {

    public List<List<Flight>> find(Repository repository, SearchCriteria searchCriteria) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Searching for flights from ");
        stringBuilder.append(searchCriteria.getDepartureAirport());
        stringBuilder.append(" on ");
        stringBuilder.append(searchCriteria.getDate());
        System.out.println(stringBuilder.toString());

        List<Flight> flights = repository.accessFlightList();

        return flights.stream()
                .filter(f -> f.getFlightRoute().getFrom().equals(searchCriteria.getDepartureAirport()))
                .filter(f -> f.getDepartureDateTime().toLocalDate().equals(searchCriteria.getDate()))
                .map(f -> new ArrayList<Flight>(Arrays.asList(f)))
                .collect(toList());
    }
}

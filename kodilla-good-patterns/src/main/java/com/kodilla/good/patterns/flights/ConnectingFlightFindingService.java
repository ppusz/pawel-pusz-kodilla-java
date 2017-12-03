package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.retrievers.FlightsRetriever;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ConnectingFlightFindingService implements FlightFindingService {

    public List<List<Flight>> find(Repository repository, SearchCriteria sc) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Searching for connecting flights from ");
        stringBuilder.append(sc.getDepartureAirport());
        stringBuilder.append(" to ");
        stringBuilder.append(sc.getDestinationAirport());
        stringBuilder.append(" on ");
        stringBuilder.append(sc.getDate());
        System.out.println(stringBuilder.toString());

        List<List<Flight>> connectingFlights = new ArrayList<>();
        List<Flight> flights = repository.accessFlightList();

        flights.stream()
                .filter(f -> f.getFlightRoute().getFrom().equals(sc.getDepartureAirport()))
                .filter(f -> f.getDepartureDateTime().toLocalDate().equals(sc.getDate()))
                .forEach(f -> flights.stream()
                        .filter(e -> e.getFlightRoute().getTo().equals(sc.getDestinationAirport()))
                        .filter(e -> e.getFlightRoute().getFrom().equals(f.getFlightRoute().getTo()))
                        .filter(e -> ChronoUnit.MINUTES.between(f.getArrivalDateTime(), e.getDepartureDateTime())
                                >= sc.getMinMinutesBetweenFlights())
                        .filter(e -> ChronoUnit.MINUTES.between(f.getArrivalDateTime(), e.getDepartureDateTime())
                                <= sc.getMaxMinutesBetweenFlights())
                        .map(e -> {List<Flight> l = new ArrayList<>(); l.add(f); l.add(e); return l;})
                        .forEach(connectingFlights::add));

        return connectingFlights;
    }
}

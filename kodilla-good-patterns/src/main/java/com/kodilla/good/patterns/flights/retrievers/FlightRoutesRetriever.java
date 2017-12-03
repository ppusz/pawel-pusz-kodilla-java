package com.kodilla.good.patterns.flights.retrievers;

import com.kodilla.good.patterns.flights.Airport;
import com.kodilla.good.patterns.flights.FlightRoute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightRoutesRetriever {

    public List<FlightRoute> retrieve() {
        List<FlightRoute> routes = new ArrayList<>();
        Map<String, Airport> airports = new AirportsRetriever().retrieve();

        airports.entrySet().stream()
                .map(e -> e.getValue())
                .forEach(e -> airports.entrySet().stream()
                        .filter(entry -> ! entry.getValue().equals(e))
                        .map(entry -> new FlightRoute(e, entry.getValue()))
                        .forEach(routes::add));

        return routes;
    }
}

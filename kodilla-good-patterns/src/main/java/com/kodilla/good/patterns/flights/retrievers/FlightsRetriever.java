package com.kodilla.good.patterns.flights.retrievers;

import com.kodilla.good.patterns.flights.Flight;
import com.kodilla.good.patterns.flights.FlightRoute;
import com.kodilla.good.patterns.flights.builders.FlightBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightsRetriever {

    final static LocalDate DATE = LocalDate.of(2017,12,24);

    public List<Flight> retrieve() {

        List<Flight> flights = new ArrayList<>();
        List<FlightRoute> routes = new FlightRoutesRetriever().retrieve();
        FlightBuilder builder = FlightBuilder.aFlight();

        builder.withFlightRoute(routes.get(0));
        builder.withDepartureDateTime(DATE.atTime(14,0));
        builder.withArrivalDateTime(DATE.atTime(14,50));
        flights.add(builder.build());

        builder.withFlightRoute(routes.get(1));
        builder.withDepartureDateTime(DATE.atTime(5,0));
        builder.withArrivalDateTime(DATE.atTime(5,30));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(13,0));
        builder.withArrivalDateTime(DATE.atTime(13,30));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(21,0));
        builder.withArrivalDateTime(DATE.atTime(21,30));
        flights.add(builder.build());

        builder.withFlightRoute(routes.get(2));
        builder.withDepartureDateTime(DATE.atTime(12,15));
        builder.withArrivalDateTime(DATE.atTime(13,5));
        flights.add(builder.build());

        builder.withFlightRoute(routes.get(3));
        builder.withDepartureDateTime(DATE.atTime(6,10));
        builder.withArrivalDateTime(DATE.atTime(6,50));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(13,10));
        builder.withArrivalDateTime(DATE.atTime(13,50));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(22,30));
        builder.withArrivalDateTime(DATE.atTime(23,10));
        flights.add(builder.build());

        builder.withFlightRoute(routes.get(4));
        builder.withDepartureDateTime(DATE.atTime(4,30));
        builder.withArrivalDateTime(DATE.atTime(5,0));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(12,30));
        builder.withArrivalDateTime(DATE.atTime(13,0));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(20,30));
        builder.withArrivalDateTime(DATE.atTime(21,0));
        flights.add(builder.build());

        builder.withFlightRoute(routes.get(5));
        builder.withDepartureDateTime(DATE.atTime(5,50));
        builder.withArrivalDateTime(DATE.atTime(6,30));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(12,50));
        builder.withArrivalDateTime(DATE.atTime(13,30));
        flights.add(builder.build());
        builder.withDepartureDateTime(DATE.atTime(22,10));
        builder.withArrivalDateTime(DATE.atTime(22,50));
        flights.add(builder.build());

        return flights;
    }

}

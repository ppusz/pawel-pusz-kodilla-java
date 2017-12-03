package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.retrievers.FlightsRetriever;

import java.util.List;

public class DBRepository implements Repository {

    public List<Flight> accessFlightList() {

        return new FlightsRetriever().retrieve();
    }
}

package com.kodilla.good.patterns.flights;

import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public class FlightFinder {

    FlightFindingService flightFindingService;
    Repository repository;

    public FlightFinder(final FlightFindingService flightFindingService, final Repository repository) {
        this.flightFindingService = flightFindingService;
        this.repository = repository;
    }

    public List<List<Flight>> find(SearchCriteria searchCriteria) {
        return flightFindingService.find(repository, searchCriteria);
    }
}

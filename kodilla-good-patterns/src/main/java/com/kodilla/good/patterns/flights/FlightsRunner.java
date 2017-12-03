package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.retrievers.SearchCriteriaRetriever;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public class FlightsRunner {

    public static void main(String[] args) {

        SearchCriteria searchCriteria = new SearchCriteriaRetriever().retrieve();
        Repository repository = new DBRepository();

        FlightFinder flightFinder = new FlightFinder(new DepartureFlightFindingService(), repository);
        List<List<Flight>> searchResults = flightFinder.find(searchCriteria);
        searchResults.stream().flatMap(l -> l.stream()).forEach(System.out::println);
        System.out.println("");

        flightFinder = new FlightFinder(new DestinationFlightFindingService(), repository);
        searchResults = flightFinder.find(searchCriteria);
        searchResults.stream().flatMap(l -> l.stream()).forEach(System.out::println);
        System.out.println("");

        flightFinder = new FlightFinder(new ConnectingFlightFindingService(), repository);
        searchResults = flightFinder.find(searchCriteria);
        searchResults.stream().flatMap(l -> l.stream()).forEach(System.out::println);


    }
}

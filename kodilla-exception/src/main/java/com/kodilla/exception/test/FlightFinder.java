package com.kodilla.exception.test;

import java.util.HashMap;

public final class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> connections = new HashMap<>();
        connections.put("WAW", true);
        connections.put("RZE", true);
        connections.put("KRK", false);
        connections.put("WRO", false);

        if (!connections.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Arrival airport doesn't exist!");
        }
        if (!connections.containsKey(flight.getDepartureAirport())) {
            throw new RouteNotFoundException("Departure airport doesn't exist!");
        }

        //other code creating list of available connection flights
    }

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(new Flight("RZE", "POZ"));
        } catch (RouteNotFoundException e) {
            System.out.println("Problem with the route: " + e.getMessage());
        } finally {
            System.out.println("Logging flight searches");
        }
    }
}

package com.kodilla.good.patterns.flights.retrievers;

import com.kodilla.good.patterns.flights.Airport;
import com.kodilla.good.patterns.flights.builders.AirportBuilder;

import java.util.HashMap;
import java.util.Map;

public class AirportsRetriever {

    public Map<String, Airport> retrieve() {
        Map<String, Airport> airports = new HashMap<>();
        AirportBuilder builder = AirportBuilder.anAirport();
        Airport airport;

        builder.withIata("RZE");
        builder.withIcao("EPRZ");
        builder.withName("Rzeszów–Jasionka Airport");
        builder.withMunicipality("Rzeszów");
        builder.withCountry("PL");
        airport = builder.build();
        airports.put(airport.getIata(), airport);

        builder.withIata("WAW");
        builder.withIcao("EPWA");
        builder.withName("Warsaw Chopin Airport");
        builder.withMunicipality("Warsaw");
        builder.withCountry("PL");
        airport = builder.build();
        airports.put(airport.getIata(), airport);

        builder.withIata("POZ");
        builder.withIcao("EPPO");
        builder.withName("Poznań–Ławica Airport");
        builder.withMunicipality("Poznań");
        builder.withCountry("PL");
        airport = builder.build();
        airports.put(airport.getIata(), airport);

        return airports;
    }
}

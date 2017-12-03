package com.kodilla.good.patterns.flights.builders;

import com.kodilla.good.patterns.flights.Airport;

public final class AirportBuilder {
    private String iata;
    private String icao;
    private String name;
    private String country;
    private String municipality;

    private AirportBuilder() {
    }

    public static AirportBuilder anAirport() {
        return new AirportBuilder();
    }

    public AirportBuilder withIata(String iata) {
        this.iata = iata;
        return this;
    }

    public AirportBuilder withIcao(String icao) {
        this.icao = icao;
        return this;
    }

    public AirportBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AirportBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AirportBuilder withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public Airport build() {
        return new Airport(iata, icao, name, country, municipality);
    }
}

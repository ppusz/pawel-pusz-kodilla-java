package com.kodilla.good.patterns.flights;

public class Airport {

    private String iata;
    private String icao;
    private String name;
    private String country;
    private String municipality;

    public Airport(final String iata, final String icao, final String name, final String country, final String municipality) {
        this.iata = iata;
        this.icao = icao;
        this.name = name;
        this.country = country;
        this.municipality = municipality;
    }

    public String getIata() {
        return iata;
    }

    public String getIcao() {
        return icao;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getMunicipality() {
        return municipality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return iata.equals(airport.iata);
    }

    @Override
    public int hashCode() {
        return iata.hashCode();
    }

    @Override
    public String toString() {
        return "(" + iata + ") " + municipality + ", " + country;
    }
}

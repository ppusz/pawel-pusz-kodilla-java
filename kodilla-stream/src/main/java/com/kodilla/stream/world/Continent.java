package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Continent {

    private final Set<Country> countries = new HashSet<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public Set<Country> getCountries() {
        return new HashSet<>(countries);
    }
}

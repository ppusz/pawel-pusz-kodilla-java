package com.kodilla.patterns.builder.bigmac;

public class Sauce {

    public static final String STANDARD = "STANDARD";
    public static final String BBQ = "BBQ";
    public static final String THOUSAND_ISLANDS = "1000 ISLANDS";
    private String name;

    public Sauce(String name) {
        if (name == STANDARD || name == BBQ || name == THOUSAND_ISLANDS) {
            this.name = name;
        } else {
            throw new IllegalStateException("Sauces can be only STANDARD, BBQ or 1000 ISLANDS!");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

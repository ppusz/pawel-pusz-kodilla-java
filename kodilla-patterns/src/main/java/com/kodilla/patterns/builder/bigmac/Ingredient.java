package com.kodilla.patterns.builder.bigmac;

public class Ingredient {

    public static final String LETTUCE = "LETTUCE";
    public static final String ONION = "ONION";
    public static final String BACON = "BACON";
    public static final String CUCUMBER = "CUCUMBER";
    public static final String CHILI = "CHILI";
    public static final String MUSHROOMS = "MUSHROOMS";
    public static final String PRAWNS = "PRAWNS";
    public static final String CHEESE = "CHEESE";

    private String name;

    public Ingredient(String name) {
        switch (name) {
            case LETTUCE:
            case ONION:
            case BACON:
            case CUCUMBER:
            case CHILI:
            case MUSHROOMS:
            case PRAWNS:
            case CHEESE:
                this.name = name;
                break;
            default:
                throw new IllegalStateException("Ingredient can be only: "
                        + "LETTUCE, ONION, BACON, CUCUMBER, CHILI, MUSHROOMS, PRAWNS or CHEESE");
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

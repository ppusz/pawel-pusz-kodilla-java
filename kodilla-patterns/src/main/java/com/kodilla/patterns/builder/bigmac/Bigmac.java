package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private List<Ingredient> ingredients;

    public static class BigmacBuilder {

        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Bigmac build() {
            if (bun == null) {
                throw new IllegalStateException("Can not build Bigmac without a bun!");
            }
            if (burgers < 0) {
                throw new IllegalStateException("Burgers count can not be negative!");
            }
            if (burgers > 5) {
                throw new IllegalStateException("Burgers count can be max 5!");
            } if (ingredients.size() > 10) {
                throw new IllegalStateException("Max 10 ingredients allowed!");
            }

            return new Bigmac(bun, burgers, sauce, ingredients);
        }

        public BigmacBuilder bun(boolean withSesame) {
            bun = new Bun(withSesame);
            return this;
        }

        public BigmacBuilder burgers(int burgersCount) {
            burgers = burgersCount;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = new Sauce(sauce);
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(new Ingredient(ingredient));
            return this;
        }
    }

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac {" +
                "Bun " + bun + ", " +
                burgers + " burger" + (burgers > 1 ? "s": "") + ", " +
                (sauce != null ? sauce : "no") + " sauce" +
                ", ingredients: " + ingredients +
                '}';
    }
}

package com.kodilla.good.patterns.challenges;

public class MovieStoreRunner {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movies = movieStore.getMoviesAsStringLine();
        System.out.println(movies);
    }
}

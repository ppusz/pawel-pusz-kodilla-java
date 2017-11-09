package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        return result;
    }
}

package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.StringJoiner;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Dupa biskupa", s -> "@@@" + s + "@@@");
        poemBeautifier.beautify("Ala ma kota",
                s -> new StringBuilder()
                        .append("###")
                        .append(s)
                        .append("###")
                        .toString());
        poemBeautifier.beautify("don't scream!!!11111oneoneone", s -> s.toUpperCase());
        poemBeautifier.beautify("Java 4-ever", s -> new StringBuilder(s).reverse().toString());
    }

}
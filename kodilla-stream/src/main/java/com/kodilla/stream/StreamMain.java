package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        PoemDecorator poemDecorator =
                s -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < s.length(); i++) {
                        if (i % 2 == 0) {
                            stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
                        } else {
                            stringBuilder.append(String.valueOf(s.charAt(i)).toLowerCase());
                        }
                    }
                    return stringBuilder.toString();
                };
        poemBeautifier.beautify("abcdefghijklmnopqqrstuvwxyz", poemDecorator);

        poemDecorator = s -> IntStream.range(0, s.toCharArray().length)
                    .mapToObj((int i ) -> (i % 2 == 0) ? s.substring(i, i + 1).toUpperCase() : s.substring(i, i + 1).toLowerCase())
                    .collect(Collectors.joining());

        poemBeautifier.beautify("abcdefghijklmnopqqrstuvwxyz", s -> IntStream.range(0, s.toCharArray().length)
                .mapToObj(i -> (i % 2 == 0) ? s.substring(i, i + 1).toUpperCase() : s.substring(i, i + 1).toLowerCase())
                .collect(Collectors.joining()));


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }

    public static String characterSizeChanger(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else {
                stringBuilder.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

    public static String characterSizeChanger2(String s) {
        return IntStream.range(0, s.toCharArray().length)
                .mapToObj((int i ) -> (i % 2 == 0) ? s.substring(i, i + 1).toUpperCase() : s.substring(i, i + 1).toLowerCase())
                .collect(Collectors.joining());


//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (i % 2 == 0) {
//                stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
//            } else {
//                stringBuilder.append(String.valueOf(s.charAt(i)).toLowerCase());
//            }
//        }
//        return stringBuilder.toString();
    }


}
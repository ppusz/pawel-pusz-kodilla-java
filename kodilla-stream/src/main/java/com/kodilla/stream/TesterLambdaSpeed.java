package com.kodilla.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TesterLambdaSpeed {

    public static String funnyWritting(String s) {
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

    public static String funnyWrittingLambda(String s) {
        return IntStream.range(0, s.toCharArray().length)
                .mapToObj((int i ) -> (i % 2 == 0) ? s.substring(i, i + 1).toUpperCase() : s.substring(i, i + 1).toLowerCase())
                .collect(Collectors.joining());

    }

    public static void main(String[] args) {
        long beginTime;
        long endTime;
        int loopsCount = 100000000;
        final String INPUT_TEXT = "abcdefghijklmnopqqrstuvwxyz";
        String resutlText;



        beginTime = System.nanoTime();
        for (int i = 0; i < loopsCount; i++ ) {
            resutlText = funnyWrittingLambda(INPUT_TEXT);
        }
        endTime = System.nanoTime();
        System.out.println("Speed with lambda: " + (endTime - beginTime)/1000000.);

        beginTime = System.nanoTime();
        for (int i = 0; i < loopsCount; i++ ) {
            resutlText = funnyWritting(INPUT_TEXT);
        }
        endTime = System.nanoTime();
        System.out.println("Speed without lambda: " + (endTime - beginTime)/1000000.);
    }

}

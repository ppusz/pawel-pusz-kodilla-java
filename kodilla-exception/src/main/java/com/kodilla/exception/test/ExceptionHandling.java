package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String s = secondChallenge.probablyIWillThrowException(1.5, 2);
            System.out.println("Result from 'probablyIWillThrowException' method: " + s);

            s = secondChallenge.probablyIWillThrowException(2, 1.5);
            System.out.println("Result from 'probablyIWillThrowException' method: " + s);

        } catch (Exception e) {
            System.out.println("Exception caused by 'probablyIWillThrowException' occurred: " + e);
        } finally {
            System.out.println("Finally block doing something, like closing even after return statement.");
        }
    }

}

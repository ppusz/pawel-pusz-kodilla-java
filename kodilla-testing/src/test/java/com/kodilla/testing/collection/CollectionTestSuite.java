package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Testing ArrayList " + numbers);

        //When
        boolean isEmpty = oddNumbersExterminator.exterminate(numbers).isEmpty();

        //Then
        Assert.assertTrue( isEmpty );
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] testNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(testNumbers));
        System.out.println("Testing ArrayList " + numbers);

        //When
        ArrayList<Integer> onlyOddNumbers = oddNumbersExterminator.exterminate(numbers);

        //Then
        Integer[] expectedNumbers = {0, 2, 4, 6, 8, 10};
        Assert.assertArrayEquals(expectedNumbers, onlyOddNumbers.toArray());
    }
}

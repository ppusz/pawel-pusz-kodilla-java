package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] someInts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        //When
        double average = ArrayOperations.getAverage(someInts);

        //Then
        int arrayLength = someInts.length;
        Assert.assertEquals(20, arrayLength);
        Assert.assertEquals(4.5, average, 0);
    }
}

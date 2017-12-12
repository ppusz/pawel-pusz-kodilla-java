package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger logger = Logger.getInstance();

        //When
        String log = "This is a log entry";
        logger.log(log);

        //Then
        Assert.assertEquals(log, logger.getLastLog());
    }
}

package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private static TaskFactory taskFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        taskFactory = new TaskFactory();
    }

    @Test
    public void testFactoryDrivingTask() {
        //When
        Task task = taskFactory.makeTask(TaskFactory.DRIVING);

        //Then
        String taskName = task.getTaskName();
        Assert.assertEquals("Funny trip", taskName);
    }

    @Test
    public void testFactoryPaintingTask() {
        //When
        Task task = taskFactory.makeTask(TaskFactory.PAINTING);

        //Then
        String taskName = task.getTaskName();
        Assert.assertEquals("Nature", taskName);

    }

    @Test
    public void testFactoryShoppingTask() {
        //When
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING);

        //Then
        String taskName = task.getTaskName();
        Assert.assertEquals("Need something to drink", taskName);

    }
}

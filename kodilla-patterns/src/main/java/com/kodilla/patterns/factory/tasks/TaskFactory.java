package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final static String DRIVING = "DRIVING";
    public final static String PAINTING = "PAINTING";
    public final static String SHOPPING = "SHOPPING";

    public final Task makeTask(String taskClass) {
        if (taskClass == "DRIVING" ) {
            return new DrivingTask("Funny trip", "Rzeszów", "car");
        }
        if (taskClass == "PAINTING" ) {
            return new PaintingTask("Nature", "green", "tree");
        }
        if (taskClass == "SHOPPING" ) {
            return new ShoppingTask("Need something to drink", "beer", 10);
        }

        return null;
    }
}

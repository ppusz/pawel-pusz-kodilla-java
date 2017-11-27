package com.kodilla.testing.shape;

import org.junit.*;
import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0 ;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("End of tests.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @After
    public void afterEveryTest() {
        System.out.println("Test #" + testCounter + " finished.");
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        double side = 5;
        Square square = new Square(side);
        double radius = 3;
        Circle circle = new Circle(radius);
        double side1 = 3;
        double side2 = 4;
        double side3 = 5;
        Triangle triangle = new Triangle(side1, side2, side3);

        //When
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);

        //Then
        assertEquals(3,shapeCollector.getShapesQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        double side = 5;
        Square square = new Square(side);
        double radius = 3;
        Circle circle = new Circle(radius);
        double side1 = 3;
        double side2 = 4;
        double side3 = 5;
        Triangle triangle = new Triangle(side1, side2, side3);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);

        //When
        Shape retrievedShape1 = shapeCollector.getFigure(0);
        Shape retrievedShape2 = shapeCollector.getFigure(1);
        Shape retrievedShape3 = shapeCollector.getFigure(2);

        //Then
        assertEquals(square, retrievedShape1);
        assertEquals(circle, retrievedShape2);
        assertEquals(triangle, retrievedShape3);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        double side = 5;
        Square square = new Square(side);
        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(square);
        int shapesQuantity = shapeCollector.getShapesQuantity();

        //Then
        assertTrue(result);
        assertEquals(0, shapesQuantity);
    }

    @Test
    public void testRemoveFigureNotExistingFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        double side = 5;
        Square square = new Square(side);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        assertFalse(result);
    }
}

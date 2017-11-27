package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public String getShapeName() {
        return "triangle";
    }

    public double getArea() {
        double halfOfPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - side1) * (halfOfPerimeter - side2) * (halfOfPerimeter - side3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.side1, side1) != 0) return false;
        if (Double.compare(triangle.side2, side2) != 0) return false;
        return Double.compare(triangle.side3, side3) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(side1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(side2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(side3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Triangle with sides " + side1 + ", " + side2 + ", " + side3 + " and area " + getArea();
    }
}


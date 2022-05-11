package com.kodilla.testing.shape;

public class Square implements Shape{

    private double base;

    public Square(double base) {
        this.base = base;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Double getField() {
        return base*base;
    }
}

package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVE";
    public static final String PAINTINGTASK = "PAINT";
    public static final String SHOPPINGTASK = "SHOP";

    public final Task taskCreator(final String task) {
        switch (task) {
            case DRIVINGTASK:
                return new DrivingTask("driving task for today", "grocery store","bike");
            case PAINTINGTASK:
                return new PaintingTask("painting task for today","red", "bedroom");
            case SHOPPINGTASK:
                return new ShoppingTask("shopping task for today", "clocks", 2);
            default:
                return null;
        }

    }
}

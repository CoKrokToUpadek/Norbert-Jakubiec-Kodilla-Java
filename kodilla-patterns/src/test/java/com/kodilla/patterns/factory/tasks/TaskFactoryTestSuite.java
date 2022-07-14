package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.ShapeFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

   TaskFactory factory=new TaskFactory();

    @Test
    void testDrivingTask() {
        //Given
        //When
        Task drivingTask = factory.taskCreator(TaskFactory.DRIVINGTASK);
        //Then
        assert drivingTask != null;
        drivingTask.executeTask();
        assertEquals("driving task for today", drivingTask.getTaskName());
    }

    @Test
    void testPaintingTask() {
        //Given
        //When
        Task paintingTask = factory.taskCreator(TaskFactory.PAINTINGTASK);
        //Then
        assert paintingTask != null;
        paintingTask.executeTask();
        assertEquals("painting task for today", paintingTask.getTaskName());
    }

    @Test
    void testShoppingTask() {
        //Given
        //When
        Task shoppingTask = factory.taskCreator(TaskFactory.SHOPPINGTASK);
        //Then
        assert shoppingTask != null;
        shoppingTask.executeTask();
        assertEquals("shopping task for today", shoppingTask.getTaskName());
    }
}

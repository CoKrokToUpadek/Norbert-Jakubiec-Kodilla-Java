package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{

    private final String taskName;
    private final String color;
    private final String whatToPaint;

    private boolean taskExecutionStatus;


    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName=taskName;
        this.color=color;
        this.whatToPaint=whatToPaint;
        this.taskExecutionStatus=false;
    }

    @Override
    public void executeTask() {
        System.out.println(taskName+": Painting "+whatToPaint+" with the color "+color);
        taskExecutionStatus=true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecutionStatus;
    }

}

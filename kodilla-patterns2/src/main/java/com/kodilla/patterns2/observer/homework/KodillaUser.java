package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class KodillaUser implements Observable{
    private String userName;

    private final List<Observer> mentors;
    private List<String> taskList;

    public KodillaUser(String userName) {
        this.userName = userName;
        taskList=new ArrayList<>();
        mentors=new ArrayList<>();
    }

    public void sendTask(String task){
        taskList.add(task);
        notifyMentor(taskList.indexOf(task));
    }

    @Override
    public void assignMentor(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyMentor(int taskNo) {
        for (Observer mentor : mentors) {
            mentor.update(this, taskNo);
        }
    }

    @Override
    public void removeMentor(Observer observer) {

    }

    public String getUserName() {
        return userName;
    }

    public List<String> getTaskList() {
        return taskList;
    }
}

package com.kodilla.patterns2.observer.homework;

public class KodillaMentor implements Observer{

    private final String mentorName;
    private int tasksSendToReview;
    public KodillaMentor(String mentorName) {
        this.mentorName = mentorName;
    }
    @Override
    public void update(KodillaUser kodillaUser, int taskNo) {
        System.out.println("User "+kodillaUser.getUserName()+ " just send new task to review: "+kodillaUser.getTaskList().get(taskNo));
        tasksSendToReview++;
    }

    public int getTasksSendToReview() {
        return tasksSendToReview;
    }
}

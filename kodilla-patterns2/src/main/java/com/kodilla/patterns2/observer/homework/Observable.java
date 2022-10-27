package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void assignMentor(Observer observer);
    void notifyMentor(int taksNo);
    void removeMentor(Observer observer);
}
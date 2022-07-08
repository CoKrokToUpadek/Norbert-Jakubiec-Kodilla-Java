package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
   private List<String> task;

   public TaskList(){
     this.task=new ArrayList<>();
   }

   public void addTask(String task){
       this.task.add(task);
   }

    public void printTask() {
        this.task.forEach(System.out::println);
    }
}

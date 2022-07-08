package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BoardConfig {

    @Bean(name = "boardBean")
    @Scope(value = "prototype")
    public Board boardList() {
        return new Board(toDoList(),inProgressList(),doneList());
    }

    @Bean(name = "toDoList")
    @Scope(value = "prototype")
    public TaskList toDoList() {
        TaskList tempTask=new TaskList();
        tempTask.addTask("toDoList no.1");
        tempTask.addTask("toDoList no.2");
        tempTask.addTask("toDoList no.3");
        return tempTask;
    }

    @Bean(name = "inProgressList")
    @Scope(value = "prototype")
    public TaskList inProgressList() {
        TaskList tempTask=new TaskList();
        tempTask.addTask("inProgressList no.1");
        tempTask.addTask("inProgressList no.2");
        return tempTask;
    }

    @Bean(name = "doneList")
    @Scope(value = "prototype")
    public TaskList doneList() {
        TaskList tempTask=new TaskList();
        tempTask.addTask("doneList no.1");
        tempTask.addTask("doneList no.2");
        tempTask.addTask("doneList no.3");
        tempTask.addTask("doneList no.4");
        return tempTask;
    }

}

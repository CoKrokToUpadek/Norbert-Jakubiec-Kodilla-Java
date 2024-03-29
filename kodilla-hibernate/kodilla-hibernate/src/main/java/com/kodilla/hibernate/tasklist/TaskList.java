package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private int ID;
    private String listName;
    private String description;

    private List<Task> tasks=new ArrayList<>();


    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique=true)
    public int getID() {
        return ID;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }


    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }
    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }


    private void setID(int ID) {
        this.ID = ID;
    }
    private void setDescription(String description) {
        this.description = description;
    }


}

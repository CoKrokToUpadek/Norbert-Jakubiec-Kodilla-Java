package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private int ID;
    private String listName;
    private String description;


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

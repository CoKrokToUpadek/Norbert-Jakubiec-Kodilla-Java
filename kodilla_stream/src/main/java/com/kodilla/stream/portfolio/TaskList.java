package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TaskList {

    private final List<Task> tasks = new LinkedList<>();
    private final String name;

    public TaskList(final String name) {
        this.name = name;
    }


    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        return Objects.equals(name, taskList.name);
    }

}

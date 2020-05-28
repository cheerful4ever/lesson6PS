package com.example.lesson6ps;

import java.io.Serializable;

public class Task implements Serializable {
    private int ID;
    private String task_name;
    private String description;

    public Task(int ID, String task_name, String description) {
        this.ID = ID;
        this.task_name = task_name;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

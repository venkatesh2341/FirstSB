package com.task1.postAndPatch.DTO;


public class Todo {
    private  int id;
    private String task;
    private boolean status;

    public Todo(int id, String name, boolean status) {
        this.id = id;
        this.task = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String name) {
        this.task = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

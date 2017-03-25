package com.codeclan.todolist;


public class Task {

    private String name;
    private String description;
    private String category;
    private Boolean done;


    public Task(String name, String description, String category, Boolean done) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }






}

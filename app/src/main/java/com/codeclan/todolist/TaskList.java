package com.codeclan.todolist;

import java.util.ArrayList;

public class TaskList {

    private Task task;
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public int numberOfTasks(){
        return list.size();
    }

    public int numberOfCompletedTasks(){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isDone() == true ){
                count++ ;
            }
        }
        return count;
    }

    public int numberOfIncompleteTasks(){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isDone() == false ){
                count++ ;
            }
        }
        return count;
    }
}

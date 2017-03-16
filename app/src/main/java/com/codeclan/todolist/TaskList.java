package com.codeclan.todolist;

import java.util.ArrayList;

public class TaskList {

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

    public int getNumberOfTasks(){
        return list.size();
    }

    public int getNumberOfCompletedTasks(){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isDone() == true ){
                count++ ;
            }
        }
        return count;
    }

    public int getNumberOfIncompleteTasks(){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isDone() == false ){
                count++ ;
            }
        }
        return count;
    }

    public void deleteAllCompletedTasks(){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isDone() == true ){
                list.remove(i);
            }
        }
    }

    public void deleteAllTasks(){
        list.clear();
    }

    public void markTaskAsComplete(Task task){
        task.setDone(true);
    }

    public void markTaskAsIncomplete(Task task){
        task.setDone(false);
    }

}

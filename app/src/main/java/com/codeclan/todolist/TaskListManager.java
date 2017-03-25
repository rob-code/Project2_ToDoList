package com.codeclan.todolist;

import java.util.ArrayList;

public class TaskListManager {

    private ArrayList<Task> list;

    public TaskListManager(ArrayList<Task> list) {
        this.list = list;
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

    public void overWriteTask(Task oldTask, Task newTask){
        list.set(list.indexOf(oldTask), newTask);
    }

//    public ArrayList<Task> listSortedByCategory() {
//
//        return;
//    }
//
//    public ArrayList<Task> listSortedByPriority() {
//
//        return;
//    }
//
//    public ArrayList<Task> listSortedByDate() {
//
//        return;
//    }
//
//    public ArrayList<Task> listSortedByDoneNotDone() {
//
//        return;
//    }


}


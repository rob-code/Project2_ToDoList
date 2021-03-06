package com.codeclan.todolist;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class ListSharedHistory {

    private SharedPreferences sharedPrefs;
    private ArrayList<Task> taskList;
    private TaskListManager taskListManager;

    public ListSharedHistory(SharedPreferences sharedPrefs){

        this.sharedPrefs = sharedPrefs;

    }

    public ArrayList<Task> getList(){

        SharedPreferences.Editor editor = sharedPrefs.edit();

        String retrievedTaskList = sharedPrefs.getString("taskList", "Nothing here");

        Gson gson = new Gson();

        if (retrievedTaskList.equals("Nothing here")){

            //seed the list
            SeedTasks seedList = new SeedTasks();
            editor.putString("taskList", gson.toJson(seedList.getSeedTasks()));
            editor.apply();
        }

        // recover the taskList from SharedPrefrences
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        taskList = gson.fromJson(retrievedTaskList, taskArrayList.getType());
        return taskList;
    }

    public void addTask(ArrayList<Task> list, Task task){

        //make the new list by appending the new task to the saved list
        taskListManager = new TaskListManager(list);
        taskListManager.addTask(task);
        ArrayList<Task> newList = taskListManager.getList();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("taskList", gson.toJson(newList));
        editor.apply();
    }

    public void markAsTrue(ArrayList<Task> list, Task task){
        taskListManager = new TaskListManager(list);
        taskListManager.markTaskAsComplete(task);

    }

    public void markAsFalse(ArrayList<Task> list, Task task){
        taskListManager = new TaskListManager(list);
        taskListManager.markTaskAsIncomplete(task);

    }



}

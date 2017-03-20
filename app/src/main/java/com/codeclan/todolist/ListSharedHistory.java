package com.codeclan.todolist;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class ListSharedHistory {

    private SharedPreferences sharedPrefs;
    private ArrayList<Task> taskList;
    private SeedList seedList;
    private TaskListManager taskListManager;

    public ListSharedHistory(SharedPreferences sharedPrefs){

        this.sharedPrefs = sharedPrefs;

    }

    public ArrayList<Task> getList(){

        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String retrievedTaskList = sharedPrefs.getString("seedList", "Nothing here");

        if (retrievedTaskList.equals("Nothing here")){

            //seed the list
            seedList = new SeedList();
            editor.putString("seedList", gson.toJson(seedList.getSeedList()));
            editor.apply();
            //return seedList.getSeedList();

        }
        else if (retrievedTaskList.equals("seedList")){

            // recover the taskList from SharedPrefrences
            TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
            ArrayList<Task> myTasks = gson.fromJson(retrievedTaskList, taskArrayList.getType());
            return myTasks;
        }

            Task task = new Task("a simple task", "a task", "test", false);
            taskList = new ArrayList<Task>();
            taskList.add(task);
            return taskList;

    }

    public void addTaskToList(ArrayList<Task> list, Task task){

            taskListManager = new TaskListManager(list);
            taskListManager.addTask(task);
            ArrayList<Task> seedList = new ArrayList<Task>();
            seedList = taskListManager.getList();

            Gson gson = new Gson();
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString("seedList", gson.toJson(seedList));
            editor.apply();
        }

}

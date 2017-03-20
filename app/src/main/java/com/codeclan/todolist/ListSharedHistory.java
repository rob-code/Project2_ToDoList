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
    private SeedTasks seedList;
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
            seedList = new SeedTasks();
            editor.putString("taskList", gson.toJson(seedList.getSeedTasks()));
            editor.apply();
        }

        // recover the taskList from SharedPrefrences
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
//        Log.d("retrievedTaskList is ", retrievedTaskList);
        taskList = gson.fromJson(retrievedTaskList, taskArrayList.getType());

        ArrayList<Task> t = taskList;

        for (int i = 0; i < t.size(); i++){
            System.out.println(t.get(i).getName().toString());
        }

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

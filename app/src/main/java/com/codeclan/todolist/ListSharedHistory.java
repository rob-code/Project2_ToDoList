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

    public ListSharedHistory(SharedPreferences sharedPrefs){

        this.sharedPrefs = sharedPrefs;

    }

    public ArrayList<Task> getList(){

        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String retrievedTaskList = sharedPrefs.getString("seedList", "Nothing here");

        if (retrievedTaskList.equals("Nothing here")){

            //seed the list and make the taskList = seedList
            seedList = new SeedList();
            taskList = seedList.getSeedList();
            editor.putString("taskList", gson.toJson(taskList));
            editor.apply();
        }
        else if (retrievedTaskList.equals("seedList")){

            // recover the taskList from SharedPrefrences
            TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
            ArrayList<Task> taskList = gson.fromJson(retrievedTaskList, taskArrayList.getType());
        }

        return taskList;

    }




//    public boolean checkSharedHistoryExists(){
//
//
//    }


    public void seedListIfNoneExists(){


    }





//    public void saveListInSharedHistory(ArrayList<Task>){
//
//        public void updateLog(SharedPreferences sharedPref, WorkoutLog log){
//            Gson gson = new Gson();
//            this.workoutLog = log;
//            SharedPreferences.Editor editor = sharedPref.edit();
//            editor.putString("WorkoutLog", gson.toJson(workoutLog));
//            editor.apply();
//        }
//
//
//
//    }





}
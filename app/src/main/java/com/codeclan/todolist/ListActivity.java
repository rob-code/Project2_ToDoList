package com.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        TaskList taskList = new TaskList();
        Task task1 = new Task("Shopping", "Get razor blades", "Personal", false);
        Task task2 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task3 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task4 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task5 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task6 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task7 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task8 = new Task("Wash Car", "Must get more soap", "Car", false);
        Task task9 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task10 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task11 = new Task("Wash Car", "Must get more soap", "Car", true);
        Task task12 = new Task("Wash Car", "Must get more soap", "Car", true);

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);
        taskList.addTask(task5);
        taskList.addTask(task6);
        taskList.addTask(task7);
        taskList.addTask(task8);
        taskList.addTask(task9);
        taskList.addTask(task10);
        taskList.addTask(task11);
        taskList.addTask(task12);

        ArrayList<Task> list = taskList.getList();

        ListAdapter listAdapter = new ListAdapter(this, list);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);
    }

    public void onListNameClicked(View textView){

        RelativeLayout title = (RelativeLayout) textView;
        Intent intent = new Intent(this, ShowTaskDetailsActivity.class);
        //intent.putExtra("task name", title.getText().toString());

        //just testing out for the meantime
        intent.putExtra("name", "task name stuff goes here");
        intent.putExtra("description", "task description stuff goes here");
        intent.putExtra("category", "task category stuff goes here");

        startActivity(intent);
    }



}

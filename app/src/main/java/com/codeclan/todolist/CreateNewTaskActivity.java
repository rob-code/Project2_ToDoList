package com.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateNewTaskActivity extends AppCompatActivity {

    private EditText taskName;
    private EditText taskDescription;
    private EditText taskCategory;
    private Task task;

    public static final String TASKS = "MyTasks";
    private SharedPreferences sharedPrefs;
    private ListSharedHistory sharedHistory;
    private ArrayList<Task> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);

        //add AppBar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.app_bar_menu);
        setSupportActionBar(myToolbar);

        taskName = (EditText)findViewById(R.id.input_name);
        taskDescription = (EditText)findViewById(R.id.input_description);
        taskCategory = (EditText)findViewById(R.id.input_category);
    }

    public void onCreateButtonClicked(View button){

        Intent intent = new Intent(this, ListActivity.class);

        String name = taskName.getText().toString();
        String description = taskDescription.getText().toString();
        String category = taskCategory.getText().toString();
        task = new Task(name, description, category, false);

        Log.d("it got here :", "****" + task.getName() + " " + task.getDescription());


        //TO DO - got to actually save the new task...
        sharedPrefs = getSharedPreferences(TASKS, Context.MODE_PRIVATE);
        sharedHistory = new ListSharedHistory(sharedPrefs);
        list = sharedHistory.getList();

        Log.d("the list array size is : ", String.valueOf(list.size()));


        sharedHistory.addTask(list, task);

        list = sharedHistory.getList();
        Log.d("the list array size is : ", String.valueOf(list.size()));

        Toast.makeText(CreateNewTaskActivity.this, "Task saved", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }

}

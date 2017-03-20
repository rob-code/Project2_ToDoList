package com.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewTaskActivity extends AppCompatActivity {

    EditText taskName;
    EditText taskDescription;
    EditText taskCategory;
    Task newTask;

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

        //TO DO - got to actually save the new task...

        Toast.makeText(CreateNewTaskActivity.this, "Task saved", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }

}

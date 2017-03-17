package com.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTaskDetailsActivity extends AppCompatActivity {

    TextView taskName;
    TextView taskDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_details);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        taskName = (TextView)findViewById(R.id.show_name);
        taskDescription = (TextView)findViewById(R.id.show_description);

        String name = extras.getString("name");
        String description = extras.getString("description");


        taskName.setText(name);
        taskDescription.setText(description);





}

}

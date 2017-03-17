package com.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowTaskDetailsActivity extends AppCompatActivity {

    TextView taskName;
    TextView taskDescription;
    TextView taskCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_details);

        //add AppBar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.app_bar_menu);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        taskName = (TextView)findViewById(R.id.show_name);
        taskDescription = (TextView)findViewById(R.id.show_description);
        taskCategory = (TextView)findViewById(R.id.show_category);

        String name = extras.getString("name");
        String description = extras.getString("description");
        String category = extras.getString("category");

        taskName.setText(name);
        taskDescription.setText(description);
        taskCategory.setText(category);

    }


    //AppBar with add new task action

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_new_task:
                onAddTaskClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onAddTaskClicked(){

        //RelativeLayout title = (RelativeLayout) textView;
        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        //intent.putExtra("task name", title.getText().toString());

        //just testing out for the meantime
        intent.putExtra("name", "task name stuff goes here");
        intent.putExtra("description", "task description stuff goes here");
        intent.putExtra("category", "task category stuff goes here");

        startActivity(intent);




    }









}

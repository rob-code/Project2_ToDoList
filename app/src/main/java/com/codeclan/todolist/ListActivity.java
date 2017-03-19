package com.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public static final String TASKS = "MyTasks";
    private SeedList seedList;
    private ArrayList<Task> list;
    private TaskList taskList;  //this should be the taskListManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.app_bar_menu);
        setSupportActionBar(myToolbar);

        list = new ArrayList<Task>();
        seedList = new SeedList();
        list = seedList.getSeedList();
        // list = taskList.getList(); this should really be the taskList manager if its needed

        ListAdapter listAdapter = new ListAdapter(this, list);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);
    }

    //saving the TaskList to SharedPreferences ***
    public void addListToSharedPreferences(View view){

        SharedPreferences sharedPref = getSharedPreferences(TASKS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString("taskList", gson.toJson(list));
        editor.apply(); //asynch save
    }

    public void onTaskItemClicked(View textView){

        RelativeLayout item = (RelativeLayout) textView;
        Intent intent = new Intent(this, ShowTaskDetailsActivity.class);

        //Passing the detail of the task to ShowDetailsTaskActivity
        Task t = (Task) item.getTag(); //we've passed the object through with the event
        intent.putExtra("name", t.getName());
        intent.putExtra("description", t.getDescription());
        intent.putExtra("category", t.getCategory());
        intent.putExtra("isDone", t.isDone());

        startActivity(intent);
    }



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
        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        startActivity(intent);
    }



    public void onChangeTaskCompleteStatusClicked(View view) {

        //TODO: Make list item work properly
        // So this does get the event. So how do we:
        // change the icon
        // update the task
        // redraw the list item?


        ImageView item = (ImageView) view;

        Log.d("its got here", "********** Its got here");

    }






}

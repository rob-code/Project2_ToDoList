package com.codeclan.todolist;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements SortListByOptionDialogFragment2.OnViewTypeSelected {
//   public class ListActivity extends AppCompatActivity implements SortListByOptionDialogFragment.NoticeDialogListener {

    public static final String TASKS = "myTasks";
    private static final CharSequence[] sortOptions = {"category", "priority", "do by date"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.app_bar_menu);
        setSupportActionBar(myToolbar);

        if(getIntent().getExtras() !=null) {

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            int index = extras.getInt("index");
            Log.d("extras passed in", "index is" + String.valueOf(index));
        }

        SharedPreferences sharedPrefs = getSharedPreferences(TASKS, Context.MODE_PRIVATE);
        ListSharedHistory sharedHistory = new ListSharedHistory(sharedPrefs);
        ArrayList<Task> list = sharedHistory.getList();

        ListAdapter listAdapter = new ListAdapter(this, list);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);
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
            case R.id.sort:
                onSortListClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //only show sort icon in AppBar in ListView
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.sort).setVisible(true);
        return true;
    }

    public void onAddTaskClicked(){
        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        startActivity(intent);
    }

    //present the sort options in an AlertDialog
    public void onSortListClicked(){
        FragmentManager manager = getFragmentManager();
        SortListByOptionDialogFragment2 dialog = new SortListByOptionDialogFragment2();
        dialog.show(manager, "Sort options");
    }

    @Override
    public void onViewSelected(int index) {
        if (index != -1) {
            Toast.makeText(this, "View tasks by " + sortOptions[index], Toast.LENGTH_SHORT).show();
        }
        Log.d("Dialog selected", "Dialog selected ! this" + String.valueOf(index));
    }

    public void onChangeTaskCompleteStatusClicked(View view) {

        ImageView item = (ImageView) view;

        SharedPreferences sharedPrefs = getSharedPreferences(TASKS, Context.MODE_PRIVATE);
        ListSharedHistory sharedHistory = new ListSharedHistory(sharedPrefs);
        ArrayList<Task> list = sharedHistory.getList();

        Task t = (Task)item.getTag();

        if (t.isDone()){
            item.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            sharedHistory.markAsFalse(list, (Task) item.getTag());
            Toast.makeText(ListActivity.this, "Task marked as To Do", Toast.LENGTH_SHORT).show();
        }
        else
        {
            item.setImageResource(R.drawable.ic_check_box_black_24dp);
            sharedHistory.markAsTrue(list, (Task) item.getTag());
            Toast.makeText(ListActivity.this, "Task marked as complete", Toast.LENGTH_SHORT).show();

        }

        item.refreshDrawableState();

    }


}

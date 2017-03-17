package com.codeclan.todolist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Task> {

    public ListAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.task_item,
                    parent,
                    false);
        }

        Task currentTask = getItem(position);

        ImageView completionStatus = (ImageView)listItemView.findViewById(R.id.is_done_image);

        if (currentTask.isDone()) {
            completionStatus.setImageResource(R.drawable.green_tick);
        }
        else
        {
            completionStatus.setImageResource(R.drawable.white_tick);
        }

        TextView name = (TextView)listItemView.findViewById(R.id.name);
        name.setText(currentTask.getName().toString());

        return listItemView;

    }

}

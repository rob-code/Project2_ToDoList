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
            completionStatus.setImageResource(R.drawable.ic_check_box_black_24dp);
        }
        else
        {
            completionStatus.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        TextView name = (TextView)listItemView.findViewById(R.id.name);
        name.setText(currentTask.getName().toString());

        //make sure the setTag method is set on the object that is actually generating the onClick
        //event ... else it wont be passed through.
        listItemView.setTag(currentTask);

        return listItemView;

    }

}

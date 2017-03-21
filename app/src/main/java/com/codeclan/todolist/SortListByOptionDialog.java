package com.codeclan.todolist;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by user on 21/03/2017.
 */

public class SortListByOptionDialog extends DialogFragment {


    private static final CharSequence[] sortOptions = {"Category", "Priority", "Do by Date"};
    private Context context;

    public SortListByOptionDialog(){
        this.context = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        this.setStyle(STYLE_NORMAL, 0);
        final Context context = getActivity();

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.sort);
        builder.setSingleChoiceItems(sortOptions, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item){
                Toast.makeText(context, "Sort by " + sortOptions[item], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        });
        return builder.create();
    }



}

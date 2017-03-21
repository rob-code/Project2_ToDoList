package com.codeclan.todolist;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by user on 21/03/2017.
 */


public class SortListByOptionDialog extends DialogFragment {

    private static final CharSequence[] sortOptions = {"Category", "Priority", "Do by Date"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        builder.setTitle(R.string.sort);
        builder.setMessage(sortOptions[1]);
//
//        builder.setSingleChoiceItems(sortOptions, checkedItem, new DialogInterface.OnClickListener()
//       builder.
//
//
//
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int item, boolean isChecked) {
//                int chow = 23;
//            }
//
//
//
//
//        });

        //AlertDialog dialog = builder.create();

        return builder.create();
    }




}

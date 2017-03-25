package com.codeclan.todolist;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 21/03/2017.
 */

public class SortListByOptionDialogFragment extends DialogFragment {

    public interface OnViewTypeSelected {
        public void onViewSelected(int index);
    }

    private static final CharSequence[] sortOptions = {"Category", "Priority", "Do by date, Done/NotDone"};
    OnViewTypeSelected mCallback;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.sort);
        builder.setSingleChoiceItems(sortOptions, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item){

                mCallback.onViewSelected(item);

                if (item != -1) {
                    dialog.dismiss();
                }
            }

        });
        return builder.show();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnViewTypeSelected) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnViewTypeSelected");
        }
    }


}


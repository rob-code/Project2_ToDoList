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

    private static final CharSequence[] sortOptions = {"Category", "Priority", "Do by Date"};






//    // Use this instance of the interface to deliver action events
//        public interface NoticeDialogListener {
//             public void onClick(DialogFragment dialog);
//         }

        public void onClick(DialogFragment dialog) {
           // NoticeDialogListener mListener;

            Log.d("Dialog selected", "Dialog selected");
        }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Context context = getActivity();

        this.setStyle(STYLE_NORMAL, 0);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.sort);
        builder.setSingleChoiceItems(sortOptions, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item){
                Toast.makeText(context, "Sort by " + sortOptions[item], Toast.LENGTH_SHORT).show();
                Log.d("got to selection", "got to selection");
                dialog.dismiss();
            }

        });
        return builder.create();
    }


//    //Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        // Verify that the host activity implements the callback interface
//        try {
//            // Instantiate the NoticeDialogListener so we can send events to the host
//         //   mListener = (NoticeDialogListener) activity;
//        } catch (ClassCastException e) {
//            // The activity doesn't implement the interface, throw exception
//            throw new ClassCastException(activity.toString()
//                    + " must implement NoticeDialogListener");
//        }
//    }








}


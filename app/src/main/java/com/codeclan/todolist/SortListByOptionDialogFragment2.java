package com.codeclan.todolist;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by user on 22/03/2017.
 */

public class SortListByOptionDialogFragment2 extends DialogFragment {

    OnViewTypeSelected mCallback;

    public interface OnViewTypeSelected{
        public void onViewSelected(int index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sort_view_option_layout, container, false);
        getDialog().setTitle("Sort by ...");

        final RadioGroup radioGroup = (RadioGroup)rootView.findViewById(R.id.radioGroup);
        Button viewSelectButton = (Button)rootView.findViewById(R.id.select);

        viewSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                View groupView = radioGroup.findViewById(selectedId);
                int idx = radioGroup.indexOfChild(groupView);
                mCallback.onViewSelected(idx);

                if (idx != -1) {
                    dismiss();
                }
            }
        });
        return rootView;
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

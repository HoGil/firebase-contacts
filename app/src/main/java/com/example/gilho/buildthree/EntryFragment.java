package com.example.gilho.buildthree;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by gilho on 27/11/16.
 */
public class EntryFragment extends Fragment {

    private EditText mName;
    private EditText mAge;
    private EditText mStatus;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_entry, container, false);

        // inflate the widgets
        mName = (EditText)v.findViewById(R.id.edit_name);
        mAge = (EditText)v.findViewById(R.id.edit_age);
        mStatus = (EditText)v.findViewById(R.id.edit_status);

        return v;
    }




}

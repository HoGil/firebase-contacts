package com.example.gilho.buildthree;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by gilho on 27/11/16.
 */
public class ListFragment extends Fragment {

    private TextView mText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list, container, false);

        mText = (TextView)v.findViewById(R.id.test);


        return v;
    }



}

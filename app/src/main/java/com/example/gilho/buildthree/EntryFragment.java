package com.example.gilho.buildthree;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by gilho on 27/11/16.
 */
public class EntryFragment extends Fragment {

    private EditText mName;
    private EditText mAge;
    private EditText mStatus;
    private Button mButton;
    private Backend connection;
    private TextView mUserDisplay;
    private boolean sStatus;
    protected FirebaseAuth mAuth;
    protected FirebaseAuth.AuthStateListener mAuthListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_entry, container, false);

        // inflate the widgets
        mName = (EditText)v.findViewById(R.id.edit_name);
        mAge = (EditText)v.findViewById(R.id.edit_age);
        mStatus = (EditText)v.findViewById(R.id.edit_status);
        mButton = (Button)v.findViewById(R.id.button_add);
        mUserDisplay = (TextView)v.findViewById(R.id.frag_userdisplay);

        // display user name
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mUserDisplay.setText(user.getEmail());




        // open connection with firebase
        connection = new Backend();

        // set listener for button
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // boolean
                if (mStatus.getText().toString() == "single") {
                    sStatus = true;
                } else if (mStatus.getText().toString() == "taken") {
                    sStatus = false;
                } else {
                    sStatus = false;
                }

                connection.writeNewContact(mName.getText().toString(), mAge.getText().toString(), sStatus);
            }
        });

        return v;
    }




}

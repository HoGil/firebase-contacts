package com.example.gilho.buildthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference globalRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initialise database
        database = FirebaseDatabase.getInstance();
        globalRef = database.getReference();
        globalRef.child("users").child("First Message").setValue("Hello Gil");

    }
}

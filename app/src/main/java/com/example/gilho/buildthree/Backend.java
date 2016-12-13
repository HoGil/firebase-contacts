package com.example.gilho.buildthree;

import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by gilho on 11/12/16.
 */
public class Backend {

    private FirebaseDatabase database;
    private DatabaseReference userRef;
    public static int userCounter = 1;
    private ArrayList<Person> userList;
    private DataSnapshot snapshot;

    public Backend() {

        // get location referencesr
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("users");

    }


    // method to add user to firebase
    public void writeNewUser(String name, String age, boolean status) {

        Person user = new Person(userCounter, name, age, status);
        userRef.child(Integer.toString(userCounter)).setValue(user);
        userCounter++;
    }

    public DatabaseReference getDatabaseReference() {
        return userRef;
    }





}

package com.example.gilho.buildthree;

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
    public static int contactCounter = 1;
    private ArrayList<Contact> userList;
    private DataSnapshot snapshot;

    public Backend() {

        // get location referencesr
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("contacts");

    }


    // method to add user to firebase
    public void writeNewContact(String name, String age, boolean status) {

        Contact user = new Contact(contactCounter, name, age, status);
        userRef.child(Integer.toString(contactCounter)).setValue(user);
        contactCounter++;
    }

    public DatabaseReference getDatabaseReference() {
        return userRef;
    }





}

package personal.development.gilho.buildthree;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

    private FirebaseUser mUser;
    private String userId;


    public Backend() {

        // get unique id for each user
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        userId = mUser.getUid();

        // get location references
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(userId);

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

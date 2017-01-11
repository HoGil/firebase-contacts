package com.example.gilho.buildthree.Authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gilho.buildthree.MainActivity;
import com.example.gilho.buildthree.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by gilho on 29/12/16.
 */
public class Register extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    // view instances
    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mButtonRegister;

    // auth instances
    private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // views
        mEmailField = (EditText)findViewById(R.id.edit_email);
        mPasswordField = (EditText)findViewById(R.id.edit_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);

        // start initialisation of auth
        mAuth = FirebaseAuth.getInstance();

        // attach listener to register button
        mButtonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // get string credentials
                String email = mEmailField.getText().toString();
                final String password = mPasswordField.getText().toString();

                createAccount(email, password);
            }

        });

        /* deleted to be chucked into mainactivity
        // start auth state listener
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    // user is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // user is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_in:");
                }

                // update UI to show that you have logged on ??


            }
        };

        */

    }

    @Override
    protected void onStart() {
        super.onStart();

        // continuously listens to whether someone signed in
        //mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        /*
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
        */

    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount: " + email);
        if (!validateForm()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete: " + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Register.this, "AuthFailed", Toast.LENGTH_SHORT).show();
                        } else {
                            //create toast to confirm new account has been made
                            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                            //start new activity --> maybe send user to home activity
                            startActivity(new Intent(Register.this, MainActivity.class));
                            finish();
                        }
                    }
                });

    }

    private boolean validateForm() {

        boolean valid = true;

        String email = mEmailField.getText().toString();

        // what to do if there is no email address
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        // what to do if there is no password
        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }




}

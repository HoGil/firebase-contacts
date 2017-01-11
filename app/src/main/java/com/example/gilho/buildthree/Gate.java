package com.example.gilho.buildthree;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gilho.buildthree.Authenticate.Login;
import com.example.gilho.buildthree.Authenticate.Register;

/**
 * Created by gilho on 4/01/17.
 */
public class Gate extends AppCompatActivity {

    private Button mLoginButton, mRegisterButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate);

        // set views
        mLoginButton = (Button)findViewById(R.id.button_login_gate);
        mRegisterButton = (Button)findViewById(R.id.button_register_gate);

        // attach listeners
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start login activity
                Intent intent = new Intent(Gate.this, Login.class);
                startActivity(intent);
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start register activity
                Intent intent = new Intent(Gate.this, Register.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}

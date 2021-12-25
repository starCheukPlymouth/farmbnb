package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNextPage("Login");
            }
        });

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNextPage("Register");
            }
        });
    }

    private void goNextPage(String target) {
        Intent intent;
        switch (target) {
            case "Login":
                intent = new Intent(this, LoginActivity.class);
                break;
            case "Register":
                intent = new Intent(this, RegisterActivity.class);
                break;
            default:
                intent = null;
                break;
        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}
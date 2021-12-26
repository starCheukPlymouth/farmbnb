package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("back button on click");
                back();
            }
        });

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void back() {
        this.finish();
    }

    private void login() {
        EditText phoneNumberInput = findViewById(R.id.phoneNumberInput);
        EditText passwordInput = findViewById(R.id.passwordInput);

        String phoneNumber = phoneNumberInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(phoneNumber.length() <= 0 || password.length() <= 0) {
            loginError("Phone number or password is empty!");
            return;
        }

        if(phoneNumber.length() < 6 || password.length() < 6) {
            loginError("Phone number or password too short!");
            return;
        }

        boolean loginResult = validateLogin(phoneNumber, password);

        if(!loginResult) {
            loginError("Login failed, please try again.");
            return;
        }

        nextPage();
    }

    private boolean validateLogin(String phoneNumber, String password) {
        String testPhoneNumber = "848484";
        String testPassword = "888888";
        return phoneNumber.equals(testPhoneNumber) && password.equals(testPassword);
    }

    private void loginError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Login Error!")
                .setMessage(message)
                .setPositiveButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void nextPage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
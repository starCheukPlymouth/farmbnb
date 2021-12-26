package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void back() {
        this.finish();
    }

    private void register() {
        EditText phoneNumberInput = findViewById(R.id.phoneNumberInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        EditText confirmInput = findViewById(R.id.confirmInput);

        String phoneNumber = phoneNumberInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirm = confirmInput.getText().toString();

        if (phoneNumber.length() <= 0 || password.length() <= 0 || confirm.length() <= 0) {
            registerError("Input is empty!");
            return;
        }

        if (phoneNumber.length() < 6 || password.length() < 6 || confirm.length() < 6) {
            registerError("Input is too short!");
            return;
        }

        if(!password.equals(confirm)) {
            registerError("Password is not match!");
            return;
        }

        nextPage();
    }

    private void registerError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Register Error!")
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
package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linearLayout = findViewById(R.id.linearLayout);

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
        Snackbar snackbar = Snackbar.make(linearLayout, getString(R.string.login_success), Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getString(R.string.home), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage();
            }
        });
        snackbar.show();
    }

    private void nextPage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
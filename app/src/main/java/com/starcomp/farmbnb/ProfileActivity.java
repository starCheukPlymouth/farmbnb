package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.starcomp.farmbnb.model.Profile;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        createMockProfile();

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        Button recordButton = findViewById(R.id.recordButton);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRecordPage();
            }
        });

        TextView userName = findViewById(R.id.userName);
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        TextView address = findViewById(R.id.address);
        TextView userClass = findViewById(R.id.userClass);

        userName.setText(profile.getName());
        phoneNumber.setText(profile.getPhoneNumber());
        address.setText(profile.getAddress());
        userClass.setText(profile.getUserClass());
    }

    private void goToRecordPage() {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }

    private void createMockProfile() {
        profile = new Profile(
                "Stephen",
                "Curry",
                "Golden State Warriors",
                "848484",
                "888888",
                "Member"
        );
    }

    private void back() {
        this.finish();
    }
}
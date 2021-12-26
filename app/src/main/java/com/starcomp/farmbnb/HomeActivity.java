package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTRA_PRODUCT_NAME";
    public static final String FARM_HOUSE = "HARM_HOUSE";
    public static final String BARN = "BARN";
    public static final String HUT = "HUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LinearLayout farmHouse = findViewById(R.id.farmHouse);
        LinearLayout barn = findViewById(R.id.barn);
        LinearLayout hut = findViewById(R.id.hut);

        farmHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectProduct(FARM_HOUSE);
            }
        });
        barn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectProduct(BARN);
            }
        });
        hut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectProduct(HUT);
            }
        });

        Toast.makeText(getApplicationContext(), getString(R.string.login_success), Toast.LENGTH_SHORT).show();
    }

    private void selectProduct(String name) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }
}
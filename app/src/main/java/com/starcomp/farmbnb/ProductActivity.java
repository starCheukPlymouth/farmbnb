package com.starcomp.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.starcomp.farmbnb.model.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private final ArrayList<Product> products = new ArrayList<Product>();
    private Product product;

    private static final int FARM_HOUSE_INDEX = 0;
    private static final int BARN_INDEX = 1;
    private static final int HUT_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        String productName = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);
        System.out.println(productName);

        createProducts();

        getDisplayProduct(productName);

        displayProduct();

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        Button bookButton = findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book();
            }
        });
    }

    private void book() {

    }

    private void back() {
        this.finish();
    }

    private void displayProduct() {
        if (product == null) {
            System.out.println("Product is null");
            return;
        }

        TextView productName = findViewById(R.id.productName);
        ImageView productImage = findViewById(R.id.productImage);
        TextView productPrice = findViewById(R.id.productPrice);
        TextView productPriceInfo = findViewById(R.id.productPriceInfo);
        TextView catering = findViewById(R.id.catering);
        TextView detail = findViewById(R.id.detail);

        productName.setText(product.getName());
        productImage.setImageResource(product.getImage());
        productPrice.setText(product.getPriceString());
        productPriceInfo.setText(product.getPriceInfo());
        catering.setText(product.getCatering());
        detail.setText(product.getDetail());
    }

    private void getDisplayProduct(String productName) {
        switch (productName) {
            case HomeActivity.FARM_HOUSE:
                product = products.get(FARM_HOUSE_INDEX);
                break;
            case HomeActivity.BARN:
                product = products.get(BARN_INDEX);
                break;
            case HomeActivity.HUT:
                product = products.get(HUT_INDEX);
                break;
            default:
        }
    }

    private void createProducts() {
        Product farmHouse = new Product(
                "Farm House",
                R.drawable.farmhouse,
                200,
                "1 Room per 1 night",
                "breakfast basis",
                "3 bedrooms in the farmhouse. All double rooms booked on a bed and breakfast basis"
        );

        Product barn = new Product(
                "Barn",
                R.drawable.barn,
                800,
                "1 Barn per 1 night",
                "self-catering",
                "1 barn, self-catering accommodation that can hold a family of 8"
        );

        Product hut = new Product(
                "Shepherds Hut",
                R.drawable.shepherds_hut,
                1200,
                "self-catering / catered",
                "breakfast basis",
                "1 luxury Shepherds Hut with one double bedroom. Can be self-catering but can be catered"
        );

        products.add(farmHouse);
        products.add(barn);
        products.add(hut);
    }
}
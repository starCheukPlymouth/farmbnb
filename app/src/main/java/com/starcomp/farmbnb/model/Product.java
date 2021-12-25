package com.starcomp.farmbnb.model;

import com.starcomp.farmbnb.R;

public class Product {
    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public String getPriceString() {
        return "$" + price;
    }

    public String getPriceInfo() {
        return priceInfo;
    }

    public String getCatering() {
        return catering;
    }

    public String getDetail() {
        return detail;
    }

    private final String name;
    private final int image;
    private final int price;
    private final String priceInfo;
    private final String catering;
    private final String detail;

    public Product(String name, int image, int price, String priceInfo, String catering, String detail) {
        this.name = name;
        this.price = price;
        this.priceInfo = priceInfo;
        this.catering = catering;
        this.detail = detail;
        this.image = image;
    }
}

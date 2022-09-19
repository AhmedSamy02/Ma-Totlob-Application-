package com.example.dayfourtask;

import android.graphics.drawable.Drawable;

public class Product {
    public Drawable productPicture;

    public String productName;
    public String productDescription;
    public double price;

    public void setMany(Drawable ProductPicture, String ProductName, String ProductDescription,double Price) {
        this.productPicture = ProductPicture;
        this.productName = ProductName;
        this.productDescription = ProductDescription;
        price=Price;
    }

    public Product(Drawable ProductPicture, String ProductName, String ProductDescription,double Price) {
        this.productPicture = ProductPicture;
        this.productName = ProductName;
        this.productDescription = ProductDescription;
        price=Price;
    }


    public String getPrice() {
        return "$" + Double.toString(price);
    }
}

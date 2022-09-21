package com.example.dayfourtask.models;

import android.graphics.drawable.Drawable;

public class item_product {
        Drawable image;
        String title;
        int weight;
        int price;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    int imageId;

        public item_product(int imageId,Drawable image, String title, int weight, int price) {
            this.image = image;
            this.title = title;
            this.weight = weight;
            this.price = price;
            this.imageId=imageId;
        }


        public Drawable getImage() {
            return image;
        }

        public void setImage(Drawable image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
}

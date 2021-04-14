package com.example.sizzlingbites.Restaurant;

public class ResDynamicModel {
    String name, price, rating, reviews;
    int pos;

    public ResDynamicModel(String name, String price, String rating, String reviews) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}

package com.example.sizzlingbites.Restaurant;

public class ResDynamicModel {
    String name, rating, reviews;
    int pos, price;

    public ResDynamicModel(String name, int price, String rating, String reviews) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
    }

    public ResDynamicModel(String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

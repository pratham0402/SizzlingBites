package com.example.sizzlingbites.OrderAndCart;

public class OrderListModel {

    private String name;
    private int price, quantity=1;

    public OrderListModel(String name, int price) {
        this.name = name;
        this.price = price;
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
}

package com.example.sizzlingbites.DRVinterface;

import com.example.sizzlingbites.OrderAndCart.OrderListModel;

import java.util.ArrayList;

public interface UpdateSelectedItem {

    void addItems(String name, String price);

    ArrayList<OrderListModel> getItems();

}


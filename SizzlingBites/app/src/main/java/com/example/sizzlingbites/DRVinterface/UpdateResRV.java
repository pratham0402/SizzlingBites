package com.example.sizzlingbites.DRVinterface;

import com.example.sizzlingbites.Restaurant.ResDynamicModel;

import java.util.ArrayList;

public interface UpdateResRV {
        public void callBack(int position, ArrayList<ResDynamicModel> dy_items);
}

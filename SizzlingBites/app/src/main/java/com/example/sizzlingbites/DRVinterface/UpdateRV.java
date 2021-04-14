package com.example.sizzlingbites.DRVinterface;

import com.example.sizzlingbites.MainCourse.DynamicRvModel;

import java.util.ArrayList;

public interface UpdateRV {
    public void callBack(int position, ArrayList<DynamicRvModel> dy_items);
}

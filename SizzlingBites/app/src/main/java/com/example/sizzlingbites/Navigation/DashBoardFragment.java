package com.example.sizzlingbites.Navigation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.LoadMore;
import com.example.sizzlingbites.MainCourse.DashBoard;
import com.example.sizzlingbites.MainCourse.DynamicRvAdapter;
import com.example.sizzlingbites.MainCourse.DynamicRvModel;
import com.example.sizzlingbites.MainCourse.StaticRvAdapter;
import com.example.sizzlingbites.MainCourse.StaticRvModel;
import com.example.sizzlingbites.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaticRvAdapter adapter;

    List<DynamicRvModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);


        final ArrayList<StaticRvModel> item = new ArrayList<>();

        /* ********************************* */
        item.add(new StaticRvModel(R.drawable.food_pizza, "pizza"));
        item.add(new StaticRvModel(R.drawable.food_burger, "burger"));
        item.add(new StaticRvModel(R.drawable.food_fries, "fries"));
        item.add(new StaticRvModel(R.drawable.food_icecream, "ice-cream"));
        item.add(new StaticRvModel(R.drawable.food_sandwich, "sandwich"));


        return view;
    }

}

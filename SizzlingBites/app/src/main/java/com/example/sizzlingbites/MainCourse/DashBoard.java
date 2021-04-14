package com.example.sizzlingbites.MainCourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.LoadMore;
import com.example.sizzlingbites.DRVinterface.UpdateRV;
import com.example.sizzlingbites.R;
import com.example.sizzlingbites.Restaurant.resDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoard extends AppCompatActivity implements UpdateRV {

    private RecyclerView recyclerView, dy_recyclerView;
    private StaticRvAdapter adapter;
    int pos;

    ArrayList<DynamicRvModel> dy_items;
    DynamicRvAdapter dynamicRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        final ArrayList<StaticRvModel> item = new ArrayList<>();

        /** ********************************* **/
        item.add(new StaticRvModel(R.drawable.food_pizza, "pizza"));
        item.add(new StaticRvModel(R.drawable.food_burger, "burger"));
        item.add(new StaticRvModel(R.drawable.food_fries, "fries"));
        item.add(new StaticRvModel(R.drawable.food_icecream, "ice-cream"));
        item.add(new StaticRvModel(R.drawable.food_sandwich, "sandwich"));

        recyclerView = findViewById(R.id.rv_1);
        adapter = new StaticRvAdapter(item,this, DashBoard.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        /** ****************************************** **/

        dy_items = new ArrayList<>();
        dy_recyclerView = findViewById(R.id.rv_2);
        dynamicRvAdapter = new DynamicRvAdapter(dy_items);
        dy_recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dy_recyclerView.setAdapter(dynamicRvAdapter);

    }

    @Override
    public void callBack(int position, final ArrayList<DynamicRvModel> dy_items) {
        dynamicRvAdapter = new DynamicRvAdapter(dy_items);
        dynamicRvAdapter.notifyDataSetChanged();
        dy_recyclerView.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setOnItemClickListener(new DynamicRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                pos = dy_items.get(position).getPos();
                startActivity(new Intent(DashBoard.this, resDetail.class).putExtra("pos",pos));
            }
        });
    }
}

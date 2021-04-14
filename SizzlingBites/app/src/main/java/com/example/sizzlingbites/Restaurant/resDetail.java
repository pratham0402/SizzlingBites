package com.example.sizzlingbites.Restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.UpdateResRV;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class resDetail extends AppCompatActivity implements UpdateResRV{

    int pos;
    RecyclerView staticRV, dynamicRV;
    ResStaticAdapter staticAdapter;
    ResDynamicAdapter dynamicAdapter;
    ArrayList<ResStaticModel> staticModels = new ArrayList<>();
    ArrayList<ResDynamicModel> dynamicModels;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_detail);

        Intent intent = getIntent();
        pos = intent.getIntExtra("pos",0);

        /** STATIC RV **/
        staticModels.add(new ResStaticModel(R.drawable.food_2_pizza, pos));
        staticModels.add(new ResStaticModel(R.drawable.food_2_burger, pos));
        staticModels.add(new ResStaticModel(R.drawable.food_2_fried, pos));
        staticModels.add(new ResStaticModel(R.drawable.food_2_icecream, pos));
        staticModels.add(new ResStaticModel(R.drawable.food_2_sandwich, pos));

        staticRV = findViewById(R.id.res_rv_1);
        staticAdapter = new ResStaticAdapter(staticModels, this, resDetail.this);
        staticRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        staticRV.setAdapter(staticAdapter);
        //******************//

        /**  DYNAMIC RV **/
        dynamicModels = new ArrayList<>();
        dynamicRV = findViewById(R.id.res_rv_2);
        dynamicAdapter = new ResDynamicAdapter(dynamicModels);
        dynamicRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dynamicRV.setAdapter(dynamicAdapter);

    }

    @Override
    public void callBack(int position, final ArrayList<ResDynamicModel> res_dy_items) {
        dynamicAdapter = new ResDynamicAdapter(res_dy_items);
        dynamicAdapter.notifyDataSetChanged();
        dynamicRV.setAdapter(dynamicAdapter);

        dynamicAdapter.setOnItemClickListener(new ResDynamicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int pos = res_dy_items.get(position).getPos();
                Toast.makeText(resDetail.this, "Clicked on item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

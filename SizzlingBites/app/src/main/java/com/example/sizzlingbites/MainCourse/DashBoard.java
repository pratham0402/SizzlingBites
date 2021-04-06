package com.example.sizzlingbites.MainCourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.LoadMore;
import com.example.sizzlingbites.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoard extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter adapter;

    List<DynamicRvModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        final ArrayList<StaticRvModel> item = new ArrayList<>();

        /* ********************************* */
        item.add(new StaticRvModel(R.drawable.food_pizza, "pizza"));
        item.add(new StaticRvModel(R.drawable.food_burger, "burger"));
        item.add(new StaticRvModel(R.drawable.food_fries, "fries"));
        item.add(new StaticRvModel(R.drawable.food_icecream, "ice-cream"));
        item.add(new StaticRvModel(R.drawable.food_sandwich, "sandwich"));

        recyclerView = findViewById(R.id.rv_1);
        adapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        /* ****************************************** */

        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));
        items.add(new DynamicRvModel("Burger"));

        RecyclerView rv2 = findViewById(R.id.rv_2);
        rv2.setLayoutManager(new LinearLayoutManager(this)); //by default vertical
        dynamicRvAdapter = new DynamicRvAdapter(rv2, this, items);
        rv2.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 10){
                    item.add(null);
                    dynamicRvAdapter.notifyItemInserted(items.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            dynamicRvAdapter.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end = index+10;
                            for (int i=index; i<end; i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRvModel item = new DynamicRvModel(name);
                                items.add(item);
                            }
                            dynamicRvAdapter.notifyDataSetChanged();
                            dynamicRvAdapter.setLoaded();
                        }
                    },4000);

                }
                else
                    Toast.makeText(DashBoard.this, "Data Completed", Toast.LENGTH_SHORT).show();
            }
        });





    }
}

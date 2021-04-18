package com.example.sizzlingbites.OrderAndCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sizzlingbites.DRVinterface.UpdateSelectedItem;
import com.example.sizzlingbites.R;

public class ConfirmOrder extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView confirmRV;
    ImageView add, minus;
    TextView name,price;
    ConfirmOrderAdapter adapter;
    Activity context;
    UpdateSelectedItem updateSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        toolbar = findViewById(R.id.confirm_toolbar);
        toolbar.setTitle("Confirm Order");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        confirmRV = findViewById(R.id.confirm_RV);
        adapter = new ConfirmOrderAdapter(context);
        confirmRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        confirmRV.setAdapter(adapter);

    }
}

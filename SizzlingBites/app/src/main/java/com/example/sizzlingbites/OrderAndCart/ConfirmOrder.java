package com.example.sizzlingbites.OrderAndCart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.UpdateSelectedItem;
import com.example.sizzlingbites.Login_AND_SignUp.UserInfo;
import com.example.sizzlingbites.MainCourse.DashBoard;
import com.example.sizzlingbites.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class ConfirmOrder extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView confirmRV;
    ImageView add, minus;
    TextView name,price, orderID;
    ConfirmOrderAdapter adapter;
    Activity context;
    UpdateSelectedItem updateSelectedItem;
    Button confirmBtn;
    FirebaseAuth firebaseAuth;
    static int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        confirmBtn = findViewById(R.id.confirm_btn);
        orderID = findViewById(R.id.order_id);


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

        /////////////update se item lenge
        /**
         * static int = 1; convert to string
         FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
         DatabaseReference myref = firebaseDatabase.getReference("orders/o-1/"+firebaseAuth.getUid());
         myref.setValue(userInfo);
         * **/

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void confirm(View v){

        Random random = new Random();
        int j = random.nextInt(10000);

        String s = Integer.toString(j);
        String e = DashBoard.email.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("orders/ord-"+s+"/");

        ArrayList<OrderListModel> orders = ((UpdateSelectedItem) ApplicationMain.getMyContext()).getItems();

        ref.setValue(orders);

        Toast.makeText(this, "Ordered Confirmed ", Toast.LENGTH_SHORT).show();

        ++i;

        orderID.setText("Order ID : "+s);

    }
}

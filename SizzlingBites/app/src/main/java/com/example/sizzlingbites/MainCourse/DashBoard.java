package com.example.sizzlingbites.MainCourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.LoadMore;
import com.example.sizzlingbites.DRVinterface.UpdateRV;
import com.example.sizzlingbites.Login_AND_SignUp.Login;
import com.example.sizzlingbites.Navigation.MyProfileFragment;
import com.example.sizzlingbites.R;
import com.example.sizzlingbites.Restaurant.resDetail;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoard extends AppCompatActivity implements UpdateRV, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView, dy_recyclerView;
    private StaticRvAdapter adapter;
    int pos;

    //Drawer for Navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ArrayList<DynamicRvModel> dy_items;
    DynamicRvAdapter dynamicRvAdapter;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        firebaseAuth = FirebaseAuth.getInstance();

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


        /**  Navigation **/
//        navigationView.bringToFront();
        navigationView = findViewById(R.id.navi_dash);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(DashBoard.this, Login.class));
                break;

            case R.id.nav_profile:
                MyProfileFragment myProfileFragment = new MyProfileFragment();
                startActivity(new Intent(this, MyProfileFragment.class));
                break;
        }
        return true;
    }
}

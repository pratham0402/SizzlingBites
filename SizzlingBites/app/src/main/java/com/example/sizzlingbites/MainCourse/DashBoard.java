package com.example.sizzlingbites.MainCourse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sizzlingbites.DRVinterface.UpdateRV;
import com.example.sizzlingbites.Login_AND_SignUp.Login;
import com.example.sizzlingbites.Login_AND_SignUp.UserInfo;
import com.example.sizzlingbites.Navigation.AboutUS;
import com.example.sizzlingbites.Navigation.Profile;
import com.example.sizzlingbites.OrderAndCart.ConfirmOrder;
import com.example.sizzlingbites.R;
import com.example.sizzlingbites.Restaurant.resDetail;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity implements UpdateRV, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView, dy_recyclerView;
    private StaticRvAdapter adapter;
    int pos;
    ImageView nav;

    //Drawer for Navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ArrayList<DynamicRvModel> dy_items;
    DynamicRvAdapter dynamicRvAdapter;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference reference;


    ///********////
    public static TextView name, email;
    ImageView img,proButton;
    Uri imgURI;
    UserInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("user2/"+firebaseAuth.getUid());

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
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        /////////
        View headerView = navigationView.getHeaderView(0);
        name = headerView.findViewById(R.id.header_name);
        email = headerView.findViewById(R.id.header_email);
        img = headerView.findViewById(R.id.header_user);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info!=null) {
                    choosePicture();
                }
                else{
                    Toast.makeText(DashBoard.this, "You cannot add profile pic ......", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                info = snapshot.getValue(UserInfo.class);
                if(info != null){
                    if (info.getMob()!=null){
                        name.setText(info.getMob());
                    }
                    if(info.getEmail() != null) {
                        email.setText(info.getEmail());
                    }

                    if (info.getImg() != null){
                        img.setImageURI(info.getImg());
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DashBoard.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        proButton = findViewById(R.id.userProfile);
        proButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, Profile.class));
            }
        });
    }

    /***        SET PROFILE PIC          **/

    private void choosePicture() {

        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imgURI = data.getData();
            img.setImageURI(imgURI);

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserInfo info = snapshot.getValue(UserInfo.class);
                    String n,p,e;
                    n = info.getMob().toString();
                    p = info.getPass().toString();
                    e = info.getEmail().toString();
                    UserInfo new_info = new UserInfo(e, p, n, imgURI);
                    DatabaseReference myref = database.getReference("user2/"+firebaseAuth.getUid());
                    //myref.setValue(new_info);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(DashBoard.this, error.getCode(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**********************************************************************************************/
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
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                MyProfileFragment myProfileFragment = new MyProfileFragment();
//                transaction.replace(R.id.container, myProfileFragment);
////                startActivity(new Intent(this, MyProfileFragment.class));
                startActivity(new Intent(this, Profile.class));
                break;

            case R.id.nav_about:
                startActivity(new Intent(this, AboutUS.class));
                break;

            case R.id.nav_cart:
                startActivity(new Intent(this, ConfirmOrder.class));
                break;
        }
        return true;
    }
}

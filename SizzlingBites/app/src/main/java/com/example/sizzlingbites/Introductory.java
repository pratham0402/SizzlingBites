package com.example.sizzlingbites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sizzlingbites.Login_AND_SignUp.Login;
import com.example.sizzlingbites.OnbroadingFragments.onBroading_1_Fragment;
import com.example.sizzlingbites.OnbroadingFragments.onBroading_2_Fragment;
import com.example.sizzlingbites.OnbroadingFragments.onBroading_3_Fragment;

public class Introductory extends AppCompatActivity {

    ImageView logo, appName, splashImg;
    LottieAnimationView lottieAnimationView;
    Animation animation;

    private static int SPLASH_TIME_COUNT = 5500; // becoz delay is 4000
    private static final int NUM_PAGE = 3;
    private ViewPager viewPager;
    private ScreenSlidePageAdapter slidePageAdapter;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        animation = AnimationUtils.loadAnimation(this, R.anim.ob_anim);

        logo = findViewById(R.id.splash_img_2);
        appName = findViewById(R.id.splash_name);
        splashImg = findViewById(R.id.splash_img);
        lottieAnimationView = findViewById(R.id.splash_animation);

        viewPager = findViewById(R.id.liquidPager);
        slidePageAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidePageAdapter);
        viewPager.setAnimation(animation);

        splashImg.animate().translationY(-3600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2400).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
/**
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                preferences = getSharedPreferences("Shared Pref", MODE_PRIVATE);
//                boolean isFirstTime = preferences.getBoolean("firstTime", true);
//
//                if (isFirstTime){
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putBoolean("firstTime", false);
//                    editor.commit();
//                }
//                else {
//                    startActivity(new Intent(Introductory.this, Login.class));
//                    finish();
//                }
//            }
//        },SPLASH_TIME_COUNT);**/

    }

    private class ScreenSlidePageAdapter extends FragmentStatePagerAdapter{


        public ScreenSlidePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    onBroading_1_Fragment tab1 = new onBroading_1_Fragment();
                    return tab1;

                case 1:
                    onBroading_2_Fragment tab2 = new onBroading_2_Fragment();
                    return tab2;

                case 2:
                    onBroading_3_Fragment tab3 = new onBroading_3_Fragment();
                    return tab3;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGE;
        }
    }
}

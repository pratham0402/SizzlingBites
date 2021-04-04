package com.example.sizzlingbites;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    public LoginAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                LoginFragment loginFragment = new LoginFragment();
                return  loginFragment;

            case  1:
                SignUpFragment signUpFragment = new SignUpFragment();
                return signUpFragment;

                default: return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

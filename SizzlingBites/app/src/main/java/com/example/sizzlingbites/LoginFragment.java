package com.example.sizzlingbites;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText L_email, L_pass;
    Button L_btn;
    TextView forgot_pass;
    float v =0;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        L_email = view.findViewById(R.id.login_email);
        L_pass = view.findViewById(R.id.login_password);
        L_btn = view.findViewById(R.id.login_btn);
        forgot_pass = view.findViewById(R.id.forgot);

        L_email.setTranslationY(800);
        L_pass.setTranslationY(800);
        L_btn.setTranslationY(800);
        forgot_pass.setTranslationY(800);

        L_email.setAlpha(v);
        L_pass.setAlpha(v);
        L_btn.setAlpha(v);
        forgot_pass.setAlpha(v);

        L_email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        L_pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        L_btn.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgot_pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return view;
    }

}

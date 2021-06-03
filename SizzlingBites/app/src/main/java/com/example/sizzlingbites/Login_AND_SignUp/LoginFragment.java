package com.example.sizzlingbites.Login_AND_SignUp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sizzlingbites.MainCourse.DashBoard;
import com.example.sizzlingbites.Navigation.Profile;
import com.example.sizzlingbites.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText L_email, L_pass;
    Button L_btn;
    TextView forgot_pass;
    float v =0;

    FirebaseAuth firebaseAuth;

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

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            getActivity().finish();
            startActivity(new Intent(getContext(), DashBoard.class));
        }

        //login
        L_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = L_email.getText().toString().trim();
                String user_pass = L_pass.getText().toString().trim();
                if(user_email.isEmpty() || user_pass.isEmpty()){
                    Toast.makeText(getContext(), "Not entered anything ", Toast.LENGTH_SHORT).show();
                }
                else {isValid(user_email, user_pass);}
                //startActivity(new Intent(getContext(), DashBoard.class));
            }
        });

        ///forgot password
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ForgotPassword.class));
            }
        });

        return view;
    }

    //sign in function
    private void isValid(final String user_email, String user_pass) {
        firebaseAuth.signInWithEmailAndPassword(user_email, user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
//                    Intent intent1 = new Intent(getContext(), DashBoard.class);
//                    Intent intent2 = new Intent(getContext(), Profile.class);
//                    intent1.putExtra("Email", user_email);
//                    intent1.putExtra("mob",u)
                    checkemailVerification();
                } else {
                    Toast.makeText(getContext(), "Failed to Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // check for verification
    private void checkemailVerification(){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        boolean emailflag = firebaseUser.isEmailVerified();
        if (emailflag){
            //finish();
            getActivity().finish();
            Toast.makeText(getContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), DashBoard.class));
        }
        else{
            Toast.makeText(getContext(), "Verify your Email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}

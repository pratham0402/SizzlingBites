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
import android.widget.Toast;

import com.example.sizzlingbites.MainCourse.DashBoard;
import com.example.sizzlingbites.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    String user_email, user_pass, con_pass, mob;
    EditText signEmail, signPass, signCpass, signMob;
    Button signBtn;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        signBtn = view.findViewById(R.id.signup_btn);
        signCpass = view.findViewById(R.id.signup_confirm_password);
        signEmail = view.findViewById(R.id.signup_email);
        signMob = view.findViewById(R.id.signup_mobile_number);
        signPass = view.findViewById(R.id.signup_password);
        firebaseAuth = FirebaseAuth.getInstance();

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()){
                    user_email = signEmail.getText().toString().trim();
                    user_pass = signPass.getText().toString().trim();
                    con_pass = signCpass.getText().toString().trim();
                    mob = signMob.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendEmailVerification();
                                sendInfo();
                                //finish();
                                //getActivity().finish();
                                //startActivity(new Intent(getContext(), DashBoard.class));
                            }
                            else {
                                Toast.makeText(getContext(), "Something went wrong may be password is too weak ...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        return view;
    }

    public boolean isValid(){
        user_email = signEmail.getText().toString().trim();
        user_pass = signPass.getText().toString().trim();
        con_pass = signCpass.getText().toString().trim();
        mob = signMob.getText().toString().trim();
        if (user_email.isEmpty() && user_pass.isEmpty() && con_pass.isEmpty() && mob.isEmpty()){
            Toast.makeText(getContext(), "Something Went Wrong TRY AGAIN", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!user_pass.equals(con_pass)){
            Toast.makeText(getContext(), "Password did not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getContext(), "Verification mail is send", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        //finish();
                        getActivity().finish();
                        //startActivity(new Intent(getContext(), DashBoard.class));
                    }else {
                        Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendInfo(){
        UserInfo userInfo = new UserInfo(user_email, user_pass, mob);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //DatabaseReference myref = firebaseDatabase.getReference(firebaseAuth.getUid());
        DatabaseReference myref = firebaseDatabase.getReference("user2/"+firebaseAuth.getUid());
        myref.setValue(userInfo);
    }

}

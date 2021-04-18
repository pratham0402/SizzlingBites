package com.example.sizzlingbites.Login_AND_SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sizzlingbites.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText forgot_email;
    TextView back;
    Button submit;
    String email;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgot_email = findViewById(R.id.forgot_email);
        back = findViewById(R.id.back_to_login);
        submit = findViewById(R.id.forgot_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this, Login.class));
                finish();
            }
        });

        email = forgot_email.getText().toString().trim();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.isEmpty()){
                    Toast.makeText(ForgotPassword.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Reset Password mail is send", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgotPassword.this, Login.class));
                            }
                            else {
                                Toast.makeText(ForgotPassword.this, "Enter correct email or else go with Mobile number", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}

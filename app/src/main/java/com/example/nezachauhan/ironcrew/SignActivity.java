package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.google.firebase.auth.FirebaseAuth.*;

public class SignActivity extends AppCompatActivity {
    TextView tvPhoneNumber;
    Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        findViews();
        setPhoneNumber();
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance().signOut();
                startActivity(new Intent(SignActivity.this,OtpActivity.class));
                finish();
            }
        });
    }
    private void findViews() {
        tvPhoneNumber=findViewById(R.id.tv_phone_number);
        btnSignOut=findViewById(R.id.btn_sign_out);
    }
    private void setPhoneNumber(){
        FirebaseUser user= getInstance().getCurrentUser();
        try {
            tvPhoneNumber.setText(user.getPhoneNumber());
        }catch (Exception e){
            Toast.makeText(this,"Phone number not found",Toast.LENGTH_SHORT).show();
        }
    }

}

package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loginactivity extends AppCompatActivity {

    Button login_btn, account_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        login_btn = (Button)findViewById(R.id.login_btn);
        account_btn = (Button)findViewById(R.id.account_btn);

        account_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Loginactivity.this,Signup.class);
                startActivity(intent);
            }
        });



    }
}

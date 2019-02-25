package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nezachauhan.ironcrew.ApiInterface.LoginApiInterface;
import com.example.nezachauhan.ironcrew.ApiManager.ApiClient;
import com.example.nezachauhan.ironcrew.ApiResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Loginactivity extends AppCompatActivity {
    EditText email, password;
    public String Email,Password;
    private String TAG = getClass().getName();
    Button login, signupbutton;
    TextView FGpassword;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbt);
        signupbutton=(Button)findViewById(R.id.signupbt);
        FGpassword = (TextView) findViewById(R.id.forgotpassword);
        FGpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Loginactivity.this, OtpActivity.class);
                startActivity(LoginIntent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckLogin();


            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Loginactivity.this, Signup.class);
                startActivity(LoginIntent);
                finish();


            }
        });


    }

    private void CheckLogin() {


        Email = email.getText().toString();
        Password = password.getText().toString();
        LoginApiInterface apiInterface = ApiClient.getClient().create(LoginApiInterface.class);
        Call<LoginResponse> loginResponseCall = apiInterface.LOGIN_RESPONSE_CALL("tag", Email, Password);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.body().getSuccess() == 200) {
                    Intent LoginIntent = new Intent(Loginactivity.this, NavigationDrawer.class);
                    startActivity(LoginIntent);
                    }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("++++++++++++++++++", t.getMessage());
            }
        });


    }
}

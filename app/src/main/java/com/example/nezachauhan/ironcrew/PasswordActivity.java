package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nezachauhan.ironcrew.ApiInterface.LoginApiInterface;
import com.example.nezachauhan.ironcrew.ApiManager.ApiClient;
import com.example.nezachauhan.ironcrew.ApiResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordActivity extends AppCompatActivity {

    EditText newpassword, confirmpassword,email;
    String NewPassword, ConfirmPassword,Email;
    Button changpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        newpassword = (EditText) findViewById(R.id.text1);
        confirmpassword = (EditText) findViewById(R.id.text2);
        changpass = (Button)findViewById(R.id.button1);

        changpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckPassword();
            }
        });

    }


    private void CheckPassword() {


        NewPassword = newpassword.getText().toString();
        ConfirmPassword = confirmpassword.getText().toString();

        if (NewPassword.equals(ConfirmPassword)) {

            LoginApiInterface apiInterface = ApiClient.getClient().create(LoginApiInterface.class);
            Call<LoginResponse> loginResponseCall = apiInterface.PASSWORD_UPDATE("tag", Email,NewPassword);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    if (response.body().getSuccess() == 200) {
                        Intent LoginIntent = new Intent(PasswordActivity.this, Loginactivity.class);
                        LoginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(LoginIntent);
                        finish();


                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(PasswordActivity.this, "Failure", Toast.LENGTH_SHORT).show();                }
            });


        } else {
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
        }
    }

}

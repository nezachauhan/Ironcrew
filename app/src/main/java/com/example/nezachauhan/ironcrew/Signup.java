package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nezachauhan.ironcrew.ApiInterface.ApiInterface;
import com.example.nezachauhan.ironcrew.ApiManager.ApiClient;
import com.example.nezachauhan.ironcrew.ApiResponse.SignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Signup extends AppCompatActivity {

    Button signup, account_btn;
    EditText email, password, contact;
    private String TAG = getClass().getName();
    String Email, Password,Contact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        account_btn = (Button)findViewById(R.id.signupbt1);
        email = (EditText) findViewById(R.id.emailsignup);
        contact = (EditText) findViewById(R.id.contactsignup);
        password = (EditText) findViewById(R.id.passwordsignup);
        signup = (Button) findViewById(R.id.creatactbt);


        account_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Signup.this,Loginactivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckSignup();
            }
        });

    }

    private void CheckSignup() {
        Log.d(TAG, "Emailid: ++++++++++" + email.getText().toString());
        Log.d(TAG, "Password: +++++++++" + password.getText().toString());
        Log.d(TAG, "Contacts: +++++++++" + contact.getText().toString());

        Email = email.getText().toString();
        Password = password.getText().toString();
        Contact = contact.getText().toString();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SignupResponse> signupResponseCall = apiInterface.SIGNUP_RESPONSE_CALL(Email, "tag", Password, Contact);
        signupResponseCall.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                if (response.body().getSuccess() == 200) {
                    Intent SignupIntent = new Intent(Signup.this, Loginactivity.class);
                    SignupIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(SignupIntent);
                    finish();

                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Log.e("+++++++++++++", t.getMessage().toString());
                Toast.makeText(Signup.this, "AfterLogin fail", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

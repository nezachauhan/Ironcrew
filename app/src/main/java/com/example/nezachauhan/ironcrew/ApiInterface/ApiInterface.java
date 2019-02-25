package com.example.nezachauhan.ironcrew.ApiInterface;

import com.example.nezachauhan.ironcrew.ApiResponse.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {
    @FormUrlEncoded
    @POST("signupControllerJson.php")
    Call<SignupResponse> SIGNUP_RESPONSE_CALL(
            @Field("s_email") String s_email,
            @Field("getSignUp") String getSignUp,
            @Field("s_password") String s_password,
            @Field("s_contact") String s_contact
    );
}

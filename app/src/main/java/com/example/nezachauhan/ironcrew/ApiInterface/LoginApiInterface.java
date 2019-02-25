package com.example.nezachauhan.ironcrew.ApiInterface;

import com.example.nezachauhan.ironcrew.ApiResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface LoginApiInterface {
    @FormUrlEncoded
    @POST("loginControllerJson.php")
    Call<LoginResponse> LOGIN_RESPONSE_CALL(
            @Field("getLogin") String getLogin,
            @Field("s_email") String s_email,
            @Field("s_password") String s_password
    );

    @FormUrlEncoded
    @POST("changePassword.php")
    Call<LoginResponse> PASSWORD_UPDATE(
            @Field("updatePassword") String updatePassword,
            @Field("s_email") String s_email,
            @Field("s_password") String s_password
    );


}

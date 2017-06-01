package com.safal.gpstrackserviceexample.Utils;

import com.safal.gpstrackserviceexample.Model.UserDetails;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("user")
    @FormUrlEncoded
    Call<UserDetails> checkUser(
            @FieldMap HashMap<String, String> params);

    @POST("locations")
    @FormUrlEncoded
    Call<Post> savePost(
            @FieldMap HashMap<String, String> params);


    class Factory {
        public static APIService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(APIService.class);
        }
    }

}
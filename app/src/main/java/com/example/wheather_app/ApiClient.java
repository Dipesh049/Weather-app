package com.example.wheather_app;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String API_KEY = "8681f9f76fe34a3592c52327221307";
    private static final String BASE_URL = "http://api.weatherapi.com";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
          retrofit = new Retrofit.Builder()
                         .baseUrl(BASE_URL)
                         .addConverterFactory(GsonConverterFactory.create())
                         .build();

        }
        return retrofit;
    }
}

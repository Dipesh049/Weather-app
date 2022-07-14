package com.example.wheather_app;

import com.example.wheather_app.WeatherModal.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//    @GET("/todos")
//    Call<List<Todo>> getTodo();
//
//    @GET("/todos/{id}")
//    Call<Todo> getTodos(@Path("id") int id);
//
//    @GET("/todos")
//    Call<Todo> getTodoUsingQuery(@Query("id") int id);
//
//    @POST("/todos")
//    Call<Todo> postTdo(@Body Todo todo);

      @GET("/v1/current.json")
      Call<WeatherModel> getWeatherDatas(@Query("key") String key,@Query("q") String cityname);


}

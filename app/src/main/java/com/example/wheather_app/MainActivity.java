package com.example.wheather_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.wheather_app.WeatherModal.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText cityname;
    TextView cityNameTextview,temp,wind,visibility,humidity,uv,air_pressure,temprature,weather_status,wind_dir;
    ImageView search;
    LottieAnimationView cloud_icon;
    SharedPreferences sharedPreferences;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityNameTextview = findViewById(R.id.cityNameTextview);
        cityname = findViewById(R.id.cityname);
        temp = findViewById(R.id.temp);
        wind = findViewById(R.id.wind);
        visibility = findViewById(R.id.visibility);
        humidity = findViewById(R.id.humidity);
        uv = findViewById(R.id.uv);
        air_pressure = findViewById(R.id.air_pressure);
        temprature = findViewById(R.id.temprature);
        weather_status = findViewById(R.id.weather_status);
        wind_dir = findViewById(R.id.wind_dir);
        search = findViewById(R.id.search_button);
        cloud_icon = findViewById(R.id.cloud_icon);


        //check permission
//        askForLocationPermission();


        // cloud animation
//        cloud_icon.setAnimation(R.raw.cloudstorm);
//        animate(cloud_icon);
        //shared preferences to save last data
         String City;
         sharedPreferences = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
         City = sharedPreferences.getString("City","Ahmedabad");
         getWeatherData(City);




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to save data in SharedPreferences.
                sharedPreferences = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("City",cityname.getText().toString().trim());
                editor.apply();
                //call api
                getWeatherData(cityname.getText().toString().trim());
            }
        });


    }



    private void getWeatherData(String cityname) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final String API_KEY = "8681f9f76fe34a3592c52327221307";
        Call<WeatherModel> call = apiInterface.getWeatherDatas(API_KEY,cityname);
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response.isSuccessful()) {
//                    Log.e("response", "onResponse: " + response.body());
                    cityNameTextview.setText(response.body().getLocation().getName());

                   String weather = response.body().getCurrent().getCondition().getText();
                   if(weather.equals("Partly cloudy")){
                       cloud_icon.setAnimation(R.raw.cloudicon);
                   }else if(weather.equals("Light rain")){
                       cloud_icon.setAnimation(R.raw.lightrain);
                   }else if(weather.equals("Mist")){
                       cloud_icon.setAnimation(R.raw.mist);
                   }else if(weather.equals("Mostly Sunny")){
                       cloud_icon.setAnimation(R.raw.mostlysunny);
                   }else{
                       cloud_icon.setAnimation(R.raw.def);
                   }
                   animate(cloud_icon);


                    wind_dir.setText(response.body().getCurrent().getWind_dir());
                    temprature.setText(response.body().getCurrent().getTempC() + "°");
                    weather_status.setText(response.body().getCurrent().getCondition().getText());
//                    Glide.with(MainActivity.this).load(response.body().getCurrent().getCondition().getIcon()).into(cloud_icon);
                    temp.setText(response.body().getCurrent().getTempC() + "°C");

                    wind.setText(response.body().getCurrent().getWindKph() + " Km/h");
                    visibility.setText(response.body().getCurrent().getVisKm() + " Km");
                    humidity.setText(response.body().getCurrent().getHumidity()+"%");
                    uv.setText(response.body().getCurrent().getUv()+"");
                    air_pressure.setText(response.body().getCurrent().getPressureMb() + " hPa");
                }else{
                    Toast.makeText(MainActivity.this, "Enter correct city name", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
//                Log.e("response", "onFailure"+ t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Enter correct city name", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //to animate the Lottiefiles
    public void animate (View view){
        cloud_icon.playAnimation();
        cloud_icon.setRepeatCount(10);
    }

//    private void askForLocationPermission() {
//       if(ContextCompat.checkSelfPermission(MainActivity.this,
//                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//             if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                     Manifest.permission.ACCESS_FINE_LOCATION)) {
//                 ActivityCompat.requestPermissions(MainActivity.this,
//                         new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
//             }else{
//                 ActivityCompat.requestPermissions(MainActivity.this,
//                 new String[] {Manifest.permission.ACCESS_FINE_LOCATION},1);
//
//             }
//        }
//
//
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                           int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 1: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    if (ContextCompat.checkSelfPermission(MainActivity.this,
//                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//
//                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//                }
//                return;
//            }
//        }
//    }






}

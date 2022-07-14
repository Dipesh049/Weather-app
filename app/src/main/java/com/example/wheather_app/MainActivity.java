package com.example.wheather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wheather_app.WeatherModal.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText cityname;
    TextView temp,wind,visibility,humidity,uv,air_pressure;
    Button serach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cityname = findViewById(R.id.cityname);
        temp = findViewById(R.id.temp);
        wind = findViewById(R.id.wind);
        visibility = findViewById(R.id.visibility);
        humidity = findViewById(R.id.humidity);
        uv = findViewById(R.id.uv);
        air_pressure = findViewById(R.id.air_pressure);
        serach = findViewById(R.id.search);

        serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    temp.setText(response.body().getCurrent().getTempC() + " °C");
                    wind.setText(response.body().getCurrent().getWindKph() + "Km/h");
                    visibility.setText(response.body().getCurrent().getVisKm() + "Km");
                    humidity.setText(response.body().getCurrent().getHumidity()+"");
                    uv.setText(response.body().getCurrent().getUv() + "");
                    air_pressure.setText(response.body().getCurrent().getPressureMb() + "hPa");
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

}
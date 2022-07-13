package com.example.wheather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){
          public void run(){
              try {
                  sleep(3000);
              }catch (Exception e){
                  e.printStackTrace();
              }
              finally {

                  Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                  startActivity(intent);
                  finish();
              }
          }
        };td.start();
    }
}
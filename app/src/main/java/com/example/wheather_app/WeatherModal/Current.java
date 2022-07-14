package com.example.wheather_app.WeatherModal;

import com.google.gson.annotations.SerializedName;

   
public class Current {



   @SerializedName("temp_c")
   float tempC;


   @SerializedName("condition")
   Condition condition;

   @SerializedName("wind_kph")
   double windKph;


   @SerializedName("pressure_mb")
   float pressureMb;


   @SerializedName("humidity")
   int humidity;


   @SerializedName("vis_km")
   float visKm;


   @SerializedName("uv")
   float uv;





    public void setTempC(int tempC) {
        this.tempC = tempC;
    }
    public float getTempC() {
        return tempC;
    }

    
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Condition getCondition() {
        return condition;
    }
    

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }
    public double getWindKph() {
        return windKph;
    }

    

    
    public void setPressureMb(int pressureMb) {
        this.pressureMb = pressureMb;
    }
    public float getPressureMb() {
        return pressureMb;
    }
    


    
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getHumidity() {
        return humidity;
    }
    

    

    public void setVisKm(int visKm) {
        this.visKm = visKm;
    }
    public float getVisKm() {
        return visKm;
    }
    

    
    public void setUv(int uv) {
        this.uv = uv;
    }
    public float getUv() {
        return uv;
    }
    

    

    
}
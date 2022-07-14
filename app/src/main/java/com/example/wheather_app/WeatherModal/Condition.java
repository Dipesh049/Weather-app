package com.example.wheather_app.WeatherModal;

import com.google.gson.annotations.SerializedName;

   
public class Condition {

   @SerializedName("text")
   String text;

   @SerializedName("icon")
   String icon;

   @SerializedName("code")
   int code;


    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIcon() {
        return icon;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    
}
package com.example.wheather_app.WeatherModal;

import com.google.gson.annotations.SerializedName;

   
public class Location {

   @SerializedName("name")
   String name;

   @SerializedName("region")
   String region;

   @SerializedName("country")
   String country;

   @SerializedName("lat")
   double lat;

   @SerializedName("lon")
   double lon;

   @SerializedName("tz_id")
   String tzId;

   @SerializedName("localtime_epoch")
   int localtimeEpoch;

   @SerializedName("localtime")
   String localtime;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegion() {
        return region;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLat() {
        return lat;
    }
    
    public void setLon(double lon) {
        this.lon = lon;
    }
    public double getLon() {
        return lon;
    }
    
    public void setTzId(String tzId) {
        this.tzId = tzId;
    }
    public String getTzId() {
        return tzId;
    }
    
    public void setLocaltimeEpoch(int localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }
    public int getLocaltimeEpoch() {
        return localtimeEpoch;
    }
    
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
    public String getLocaltime() {
        return localtime;
    }
    
}
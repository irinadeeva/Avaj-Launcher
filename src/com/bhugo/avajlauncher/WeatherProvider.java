package com.bhugo.avajlauncher;

import com.bhugo.avajlauncher.aircrаft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "SUN", "SNOW", "FOG"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

   public String getCurrentWeather(Coordinates coordinates){
        return weather[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4];
   }
}


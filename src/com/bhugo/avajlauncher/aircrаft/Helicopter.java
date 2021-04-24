package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.Coordinates;
import com.bhugo.avajlauncher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
    }
}


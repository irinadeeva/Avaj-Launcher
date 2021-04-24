package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower weatherTower);

    String getName();

    long getId();

    Coordinates getCoordinates();
}

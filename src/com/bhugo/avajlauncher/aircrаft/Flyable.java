package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}

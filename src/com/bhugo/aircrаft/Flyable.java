package com.bhugo.aircrаft;

import com.bhugo.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower WeatherTower);
}

package com.company;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon (String name, Coordinates coordinates){
        super();
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}

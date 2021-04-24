package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.changeCoordinates(10,0,2);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("I'm Lovin' It.\n");
                break;
            case "RAIN":
                this.coordinates.changeCoordinates(5,0,0);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("This poses a greater risk.\n");
                break;
            case "FOG":
                this.coordinates.changeCoordinates(1,0,0);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("All I could see is fog.\n");
                break;
            case "SNOW":
                this.coordinates.changeCoordinates(0,0,-12);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("Surprisingly, snow here never melts.\n");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        if (this.coordinates.getHeight() != 0) {
            this.weatherTower = weatherTower;
            weatherTower.register(this);
        }
    }
}


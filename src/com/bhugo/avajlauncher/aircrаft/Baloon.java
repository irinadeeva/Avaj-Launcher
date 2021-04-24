package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.changeCoordinates(2, 0, 4);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("Don't get me wrong, I like it.\n");
                break;
            case "RAIN":
                this.coordinates.changeCoordinates(0, 0, -5);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("I'm afraid we shall have rain before morning.\n");
                break;
            case "FOG":
                this.coordinates.changeCoordinates(0, 0, -3);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("We'll likely to hit fog soon.\n");
                break;
            case "SNOW":
                this.coordinates.changeCoordinates(0, 0, -15);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("Snow is my favorite thing in the whole wide world.\n");
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

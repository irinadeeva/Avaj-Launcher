package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.changeCoordinates(0,10,2);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("We've made our place in the sun, very good.\n");
                break;
            case "RAIN":
                this.coordinates.changeCoordinates(0,5,0);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("Let's go flying and mocking in the rain.\n");
                break;
            case "FOG":
                this.coordinates.changeCoordinates(0,1,0);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("All we needed was some fog.\n");
                break;
            case "SNOW":
                this.coordinates.changeCoordinates(0,0,-7);
                weatherTower.getReport().append(this.getClass().getSimpleName()).append("#").append(this.getName()).append("(").append(this.getId()).append("): ").append("The only thing we want for Christmas is snow...\n");
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


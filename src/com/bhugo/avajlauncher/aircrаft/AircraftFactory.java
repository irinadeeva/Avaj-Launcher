package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.Coordinates;
import com.bhugo.avajlauncher.WrongAircraftData;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws WrongAircraftData {

        if (longitude < 0 || latitude < 0 || height < 0)
            throw new WrongAircraftData("Please, correct coordinates. Coordinates is due to be positive.");
        if (height > 100)
            height = 100;
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            default:
                throw new WrongAircraftData("Please, correct aircraft types. " +
                        "Aircraft types are due to be \"Helicopter\", \"Baloon\", \"JetPlane\".");
        }
    }
}
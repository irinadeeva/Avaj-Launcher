package com.bhugo.avajlauncher.aircrаft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;


    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public void changeCoordinates(int longitude, int latitude, int height){
        this.longitude += longitude;
        this.latitude += latitude;
        this.height += height;
        if (this.height > 100)
            this.height = 100;
        if (this.height < 0)
            this.height = 0;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude(){
        return latitude;
    }

    public int getHeight(){
        return height;
    }
}

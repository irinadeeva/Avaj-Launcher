package com.bhugo.avajlauncher.aircrаft;

import com.bhugo.avajlauncher.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        nextId();
    }

    private long nextId(){
        return this.id = idCounter++;
    }
}

package com.bhugo.avajlauncher.aircrаft;

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

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    private long nextId(){
        return this.id = idCounter++;
    }

}

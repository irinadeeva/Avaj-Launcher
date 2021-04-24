package com.bhugo.avajlauncher;

import com.bhugo.avajlauncher.aircrаft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower{
    private List<Flyable> observers = new ArrayList<>();
    private StringBuffer report = new StringBuffer();

    public void register(Flyable flyable) {
        report.append("Tower says: ").append(flyable.getClass().getSimpleName()).append("#").append(flyable.getName()).append("(").append(flyable.getId()).append(") registered to weather tower.\n");
       observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        report.append(flyable.getClass().getSimpleName()).append("#").append(flyable.getName()).append("(").append(flyable.getId()).append(") landing.\n");
        report.append("Tower says: ").append(flyable.getClass().getSimpleName()).append("#").append(flyable.getName()).append("(").append(flyable.getId()).append(") unregistered to weather tower with coordinates (").append(flyable.getCoordinates().getLongitude()).append(",").append(flyable.getCoordinates().getLatitude()).append(", 0).\n");
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }

    public StringBuffer getReport(){
        return this.report;
    }

}


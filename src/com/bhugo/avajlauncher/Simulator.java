package com.bhugo.avajlauncher;

import com.bhugo.avajlauncher.aircrаft.AircraftFactory;
import com.bhugo.avajlauncher.aircrаft.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    static int timesToSimulationRun;
    static List<Flyable> aircraftDataList = new ArrayList<>();
    static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) {
        if (args.length == 1 && args[0].endsWith(".txt") && readFile(args[0])) {
            for (Flyable a : aircraftDataList){
                a.registerTower(weatherTower);
            }
            while (timesToSimulationRun-- > 0){
                weatherTower.changeWeather();
            }
            createReport();
        } else if (args.length == 0) {
            System.out.println("The program expects a text file that will contain the scenario to be simulated.");
        } else if (args.length == 1 && !args[0].endsWith(".txt")) {
            System.out.println("The program expects a text file. Example: scenario.txt");
        } else if (args.length > 1) {
            System.out.println("The program takes only one argument.");
        }
    }

    private static boolean readFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String sCurrentLine;

            if ((sCurrentLine = br.readLine()) != null) {
                timesToSimulationRun = Integer.parseInt(sCurrentLine);
                if (timesToSimulationRun <= 0) {
                    System.out.println("The number of times the simulation is due to run has to be positive.");
                    return (false);
                }
            }

            while ((sCurrentLine = br.readLine()) != null) {
                String[] splited = sCurrentLine.split("\\s+");
                if (splited.length != 5){
                    System.out.println("Describes an aircraft with the format: TYPE NAME LONGITUDE LATITUDE HEIGHT.");
                    return (false);
                }
                aircraftDataList.add(AircraftFactory.newAircraft(splited[0],splited[1],
                        Integer.parseInt(splited[2]),Integer.parseInt(splited[3]),Integer.parseInt(splited[4])));
            }
            br.close();

            if (aircraftDataList.size() == 0) {
                System.out.println("There is no aircraft for simulation.");
                return (false);
            }
        } catch (IOException | NumberFormatException | WrongAircraftData e) {
            System.out.println(e.getMessage());
            return(false);
        }
        return (true);
    }

    private static void createReport(){
        try {
            FileWriter myWriter = new FileWriter("simulation.txt");
            myWriter.write(String.valueOf(weatherTower.getReport()));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

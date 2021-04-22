package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    public static Scenario scenario = new Scenario();

    public static void main(String[] args) {
        if (args.length == 1 && args[0].endsWith(".txt") && readFile(args[0])) {
            System.out.println("all right");
        } else if (args.length == 0) {
            System.out.println("The program expects a text file that will contain the scenario to be simulated.");
        } else if (args.length == 1 && !args[0].endsWith(".txt")) {
            System.out.println("The program expects a text file. Example: scenario.txt");
        } else if (args.length > 1) {
            System.out.println("The program takes only one argument.");
        }
    }

    public static boolean readFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String sCurrentLine;
            if ((sCurrentLine = br.readLine()) != null) {
                scenario.timesToSimulationRun = Integer.parseInt(sCurrentLine);
                if (scenario.timesToSimulationRun <= 0) {
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
               // scenario.aircraftDataList.add(new);
                System.out.println(sCurrentLine);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return (true);
    }
}

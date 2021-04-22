package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    public static Scenario scenario = new Scenario();

    public static void main(String[] args) {
        if (args.length == 1 && args[0].endsWith(".txt")) {
            readFile(args[0]);
            System.out.println("all right");
        } else if (args.length == 0){
            System.out.println("The program expects a text file that will contain the scenario that needs to be simulated");
        } else {
            System.out.println("The program takes only one argument");
        }
    }

    public static void readFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String sCurrentLine;
            if ((sCurrentLine = br.readLine()) != null) {
                scenario.timesToSimulationRun = Integer.parseInt(sCurrentLine);
            }
            while ((sCurrentLine = br.readLine()) != null)
            {
                System.out.println(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

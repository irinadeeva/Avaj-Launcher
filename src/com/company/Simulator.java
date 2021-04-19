package com.company;

public class Simulator {
    public Scenario scenario;

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

    public void readFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String sCurrentLine;
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

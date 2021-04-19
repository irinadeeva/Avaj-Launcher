package com.company;

public class Simulator {

    public static void main(String[] args) {
        if (args.length == 1 && args[0].endsWith(".txt")) {
            System.out.println("all right");
        } else {
            System.out.println("The program takes only one argument");
        }
    }
}



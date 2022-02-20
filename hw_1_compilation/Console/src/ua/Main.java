package ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.FirstClass.FirstClass;
import ua.SecondClass.SecondClass;
import ua.ThirdClass.ThirdClass;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n\nWelcome to homework #1!\n\nThere are 3 classes with 2 libs in this project. ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "0";
            while (!line.isEmpty()) {
                System.out.println("To check the name of each one and the name of lib included, input number of class you need (1-3)");
                System.out.println("To exit press Enter");
                line = reader.readLine();
                Logic(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void Logic(String input) {
        switch (input) {
            case "1" -> System.out.println("\nThe name of class: " + new FirstClass().getClass().getName() + " Imported lib: commons-math3-3.6.1\n");
            case "2" -> System.out.println("\nThe name of class: " + new SecondClass().getClass().getName() + '\n');
            case "3" -> System.out.println("\nThe name of class: " + new ThirdClass().getClass().getName() + " Imported lib: commons-lang3-3.12.0\n");
        }
    }
}


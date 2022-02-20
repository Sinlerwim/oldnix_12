package ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to module 1!");
        System.out.println("Author: Kyrylo Savin");
        System.out.println("There are 3 levels with several tasks inside.\nChoose the level you need (1-3 or 0 te exit):");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    while(navigation(reader)) {
                        System.out.println("Choose the level you need (1-3 or 0 te exit):");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
    }


        private static boolean navigation(BufferedReader reader) throws IOException {
            String input = reader.readLine();
            switch (input) {
                case "1":
                    level1.start(reader);
                    break;
                case "2":
                    level2.start(reader);
                    break;
                case "3":
                    level3.start(reader);
                    break;
                case "0":
                    return false;
                default:
                        System.out.println("Unexpected value: \"" + input + "\". Try 1-3 for levels or 0 to exit");
            }
        return true;
    }
}

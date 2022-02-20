package ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.*;

public class level1 {

    private static Map<Integer, Character> characters = new HashMap<Integer, Character>();
    private static Map<Character, Integer> values = new HashMap<Character, Integer>();

    public static void start(BufferedReader reader) throws IOException {
        characters.put(1, 'A');
        characters.put(2, 'B');
        characters.put(3, 'C');
        characters.put(4, 'D');
        characters.put(5, 'E');
        characters.put(6, 'F');
        characters.put(7, 'G');
        characters.put(8, 'H');
        values.put('A', 1);
        values.put('B', 2);
        values.put('C', 3);
        values.put('D', 4);
        values.put('E', 5);
        values.put('F', 6);
        values.put('G', 7);
        values.put('H', 8);
        System.out.println("You are at level 1. Choose the task (1-3 or 0 te exit):");
        while(level1navigation(reader)) {
            System.out.println("Choose the task (1-3 or 0 te exit):");
        }
    }

    private static boolean level1navigation(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        switch (input) {
            case "1":
                    getUniqueSymbols(reader);
                break;
            case "2":
                    horsePossibleMovement(reader);
                break;
            case "3":
                    getTriangleArea(reader);
                break;
            case "0":
                return false;
            default:
                System.out.println("Unexpected value: \"" + input + "\". Try 1-3 for levels or 0 to exit");
        }
        return true;
    }

    private static void getTriangleArea(BufferedReader reader) throws IOException {
        System.out.println("Starting task #2");
        Map<String, Integer> points = new HashMap<String,Integer>();
        int a, b, c;
        for(int pointNumber = 1; pointNumber <= 3; pointNumber++ ) {
            System.out.println("Input x"+pointNumber);
            points.put("x"+pointNumber, Integer.parseInt(reader.readLine()));
            System.out.println("Input y"+pointNumber);
            points.put("y"+pointNumber, Integer.parseInt(reader.readLine()));
        }
        a = getSectionLength(points.get("x1"), points.get("y1"), points.get("x2"),points.get("y2"));
        b = getSectionLength(points.get("x2"), points.get("y2"), points.get("x3"),points.get("y3"));
        c = getSectionLength(points.get("x3"), points.get("y3"), points.get("x1"),points.get("y1"));
        System.out.format("Triangle area is %.2f\n",getAreaByLengths(a, b, c));
    }

    private static double getAreaByLengths(int a, int b, int c) {
        double p = 0.5*(a+b+c);
        return sqrt(p*(p-a)*(p-b)*(p-c));
    }

    private static int getSectionLength(Integer x1, Integer y1, Integer x2, Integer y2) {
        return (int) abs(sqrt(pow(x2-x1,2) + pow(y2-y1,2)));
    }

    private static void horsePossibleMovement(BufferedReader reader) throws IOException {
        System.out.println("Starting task #2");
        String horseLocation, horseMovement;
        int horseLocationX, horseLocationY, horseMovementX, horseMovementY;
        drawChessDesk();
        System.out.println("Input horse location (e.g. A1)");
        horseLocation = reader.readLine().toUpperCase();
        drawChessDesk(horseLocation);
        System.out.println("Input where you want to move the horse (e.g H2)");
        horseMovement = reader.readLine().toUpperCase();
        horseLocationX = values.get(horseLocation.charAt(0));
        horseLocationY = Character.getNumericValue(horseLocation.charAt(1));
        horseMovementX = values.get(horseMovement.charAt(0));
        horseMovementY = Character.getNumericValue(horseMovement.charAt(1));
        if(horseMovementX <= 8 && horseMovementY <=8 && horseMovementX >=1 && horseMovementY >=1) {
            if (Math.abs(horseMovementX - horseLocationX) == 2 && Math.abs(horseMovementY - horseLocationY) == 1 ||
                    Math.abs(horseMovementX - horseLocationX) == 1 && Math.abs(horseMovementY - horseLocationY) == 2) {
                System.out.println("Movement is possible");
            } else System.out.println("Movement is impossible");
        }
    }

    private static void drawChessDesk( String horseLocation) {
        for (int y = 8; y > 0; y--) {
            System.out.print(y+"\s");
            for (int x = 1; x <= 8; x++) {
                if (y == Character.getNumericValue(horseLocation.charAt(1)) && x == values.get(horseLocation.charAt(0))) {
                    System.out.print("@\s");
                } else System.out.print("#\s");
            }
            System.out.println();
        }
        System.out.print("\s\s");
        for (int x = 0; x < 8; x++) {
            System.out.print(characters.get(x+1)+"\s");
        }
        System.out.println();
    }

    private static void drawChessDesk() {
        for (int y = 8; y > 0; y--) {
            System.out.print(y+"\s");
            for (int x = 0; x < 8; x++) {
                System.out.print("#\s");
            }
            System.out.println();
        }
        System.out.print("\s\s");
        for (int x = 0; x < 8; x++) {
            System.out.print(characters.get(x+1)+"\s");
        }
        System.out.println();
    }

    public static void getUniqueSymbols(BufferedReader reader) throws IOException {
        System.out.println("Starting task #1");
        System.out.println("Input array length:");
        int arrayLength = Integer.parseInt(reader.readLine());
        int[] array = new int[arrayLength];
        for(int counter = 0; counter < arrayLength; counter++) {
            System.out.print("Input element #"+(counter+1)+':');
            array[counter] = Integer.parseInt(reader.readLine());
        }
        System.out.println("Your array is:");
        System.out.println(Arrays.toString(array));
        for (int counter = 0; counter < array.length; counter++) {
            for (int subCounter = counter+1; subCounter < array.length; ++subCounter) {
                if (array[subCounter] == array[counter]) {
                    array = deleteElement(array, subCounter);
                    subCounter--;
                }
            }
        }
        System.out.println("Array with only unique numbers:");
        System.out.println(Arrays.toString(array));
        System.out.println("Amount of unique numbers - "+array.length);

    }

    private static int[] deleteElement(int[] array, int elementNumber) {
        for(int deleteCounter = elementNumber; deleteCounter < array.length-1; deleteCounter++) {
            array[deleteCounter] = array[deleteCounter+1];
        }
        return Arrays.copyOf(array,array.length-1);
    }
}


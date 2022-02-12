import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n\nWelcome to homework #2!\n\nThere are 3 different task have done here:");
        System.out.println("1. Find number in string and sum them");
        System.out.println("2. Count all letters and print amount of each one");
        System.out.println("3. Find end-time of any lesson (1-10)\n");
        System.out.println("Choose the task you need (1-3):");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "0";
            while (!line.isEmpty()) {
                line = reader.readLine();
                Logic(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void Logic(String input) {
        switch (input) {
            case "1" -> findNumbersAndSum();
            case "2" -> findAllLetters();
            case "3" -> findLessonTime();
        }
    }

    public static void findNumbersAndSum() {
        System.out.println("Input your string:");
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            String number = "";
            for (int counter = 0; counter < input.length(); counter++) {
                if (Character.isDigit(input.charAt(counter))) {
                    number += input.charAt(counter);
                } else if (number != "") {
                    System.out.println("Number " + number + " has found. Adding...");
                    result += Integer.parseInt(number);
                    number = "";
                }
            }
            if (!number.isEmpty()) {
                System.out.println("Number " + number + " has found. Adding...");
                result += Integer.parseInt(number);
                number = "";
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Sum of every found number are " + result);
    }

    public static void findAllLetters() {
        System.out.println("Input your string:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            input = input.replaceAll("[^A-z+^]", ""); // https://www.cyberforum.ru/java/thread934834.html
            if (!input.isEmpty()) {
                System.out.println("Your string with only letter: " + input);
            } else {
                System.out.println("Your string doesn't contains any letter. Returning to main menu...");
            }
            for (int counter = 0; counter < input.length(); counter++) {
                if (Character.isLetter(input.charAt(counter))) {
                    int numberOfLetter = 0;
                    for (int subCounter = counter; subCounter < input.length(); subCounter++) {
                        if (input.charAt(subCounter) == input.charAt(counter)) {
                            numberOfLetter++;
                        }
                    }
                    System.out.println(input.charAt(counter) + " - " + numberOfLetter);
                    input = deleteAllChar(input, input.charAt(counter));
                    //                   input = input.replaceAll(String.valueOf(input.charAt(counter)), "");
                    counter--;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    private static String deleteAllChar(String input, char c) {
        String resultString = "";
        for (int counter = 0; counter < input.length(); counter++) {
            if (input.charAt(counter) != c) {
                resultString += input.charAt(counter);
            }
        }
        return resultString;
    }

    public static void findLessonTime() {
        System.out.println("Input number of lesson you need:");
        /*for (int i=1; i<=10; i++) {
            int answerMinutes = 0;
            int a = i*45;
            int b = i/2*15;
            int c = (i/2)*5;
            int d = (i%2-1)*15;

            answerMinutes += i*45 + i/2*15 + (i/2)*5 + (i%2-1)*15;
            int answerHours = 9+ answerMinutes / 60;
            answerMinutes -= 60*(answerHours-9);
            System.out.println("Lesson number "+i+ " ends in "+answerHours+':'+answerMinutes);
        }*/

        String input;
        int answerHours, answerMinutes = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine();
            answerMinutes += Integer.parseInt(input)*45 + Integer.parseInt(input)/2*15 + ((Integer.parseInt(input))/2)*5 + (Integer.parseInt(input)%2-1)*15;
            answerHours = 9+ answerMinutes / 60;
            answerMinutes -= 60*(answerHours-9);
            System.out.println("Lesson number "+input+ " ends in "+answerHours+':'+answerMinutes);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
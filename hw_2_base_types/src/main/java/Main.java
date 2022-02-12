import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n\nWelcome to homework #2!\n\nThere are 3 different task have done here:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String navigation = "";
            String line = "";
            while (!navigation.equals("0")) {
                System.out.println("1. Find number in string and sum them");
                System.out.println("2. Count all letters and print amount of each one");
                System.out.println("3. Find end-time of any lesson (1-10)\n");
                System.out.println("Choose the task you need (1-3) or 0 to exit:");
                navigation = reader.readLine();
                switch (navigation) {
                    case "1":
                        System.out.println("Input your string:");
                        line = reader.readLine();
                        System.out.println("Sum of all found numbers are " + findNumbersAndSum(line));
                        System.out.println("\nInput any symbol to return to main menu");
                        line = reader.readLine();
                        break;
                    case "2":
                        System.out.println("Input your string:");
                        line = reader.readLine();
                        findAllLetters(line);
                        System.out.println("\nInput any symbol to return to main menu");
                        line = reader.readLine();
                        break;
                    case "3":
                        System.out.println("Input number of lesson you need:");
                        line = reader.readLine();
                        findLessonTime(line);
                        System.out.println("\nInput any symbol to return to main menu");
                        line = reader.readLine();
                        break;
                    case "0": break;
                    default:
                        System.out.println("Unexpected value: \"" + navigation +"\". Try 1-3 for tasks or 0 to exit");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static int findNumbersAndSum(String input) {
        int result = 0;
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


        return result;
    }

    public static void findAllLetters(String input) {
            input = input.replaceAll("[^A-z+^]", ""); // https://www.cyberforum.ru/java/thread934834.html
            if (!input.isEmpty()) {
                System.out.println("Your string with only letters: " + input);
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

    public static void findLessonTime(String input) {
        int answerHours, answerMinutes = 0;
            answerMinutes += Integer.parseInt(input)*45 + Integer.parseInt(input)/2*15 + ((Integer.parseInt(input))/2)*5 + (Integer.parseInt(input)%2-1)*15;
            answerHours = 9+ answerMinutes / 60;
            answerMinutes -= 60*(answerHours-9);
            System.out.println("Lesson number "+input+ " ends in "+answerHours+':'+answerMinutes);

    }
}
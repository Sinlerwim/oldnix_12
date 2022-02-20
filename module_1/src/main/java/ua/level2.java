package ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class level2 {

    public static void start(BufferedReader reader) throws IOException {
        String line;
        System.out.println("You are at level 2. Here only 1 task");
        System.out.println("Input your string:");
        line = reader.readLine();
        System.out.println("Is your string allowed - " + check(line));

    }

    public static boolean check(String text) {
        Stack<Character> characterStack = new Stack<Character>();
        if (characterStack.empty()) return false;
        char[] stringAsArray = text.toCharArray();
        for (int currentNumber = stringAsArray.length - 1; currentNumber >= 0; currentNumber--) {
            characterStack.push(stringAsArray[currentNumber]);
        }
        Stack<Character> bracesNeedToBeFound = new Stack<Character>();
        try {
            while (!characterStack.empty()) {
                switch (characterStack.peek()) {
                    case ']', '}', ')':
                        if (characterStack.peek() == bracesNeedToBeFound.peek()) bracesNeedToBeFound.pop();
                        else return false;
                        break;
                    case '[':
                        bracesNeedToBeFound.push(']');
                        break;
                    case '{':
                        bracesNeedToBeFound.push('}');
                        break;
                    case '(':
                        bracesNeedToBeFound.push(')');
                        break;
                    default:
                        break;
                }
                characterStack.pop();
            }
        } catch (EmptyStackException e) {
            return false;
        }
        if (bracesNeedToBeFound.empty()) return true;
        else return false;
    }
}


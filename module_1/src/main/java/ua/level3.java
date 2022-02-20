package ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class level3 {
    public static void start(BufferedReader reader) throws IOException {
        int n, m, numberOfCycles;
        System.out.println("You are at level 3. Here only 1 task");
        System.out.println("Input n for Array:");
        n=Integer.parseInt(reader.readLine());
        System.out.println("Input m for Array:");
        m=Integer.parseInt(reader.readLine());
        System.out.println("Input number of Life-cycles:");
        numberOfCycles=Integer.parseInt(reader.readLine());
 //       lifeGame(n, m, numberOfCycles);
        boolean[][] lifeBoard = getNewBoard(n, m);
        System.out.println("Start");
        drawLifeBoard(lifeBoard);
        for (int step = 0; step < numberOfCycles; step++) {
            System.out.println("Step ¹"+(step+1));
            lifeBoard = getNextStep(lifeBoard);
            drawLifeBoard(lifeBoard);
        }
    }

    private static boolean[][] getNextStep(boolean[][] lifeBoard) {
        boolean newBoard[][] = new boolean[lifeBoard.length][lifeBoard[0].length];
        int neighborsCounter;
        for (int length = 0; length < lifeBoard.length; length++) {
            for (int width = 0; width < lifeBoard[0].length; width++) {
                neighborsCounter = 0;
                for (int neighborLength = length - 1; neighborLength <= length + 1; neighborLength++) {
                    for (int neighborWidth = width - 1; neighborWidth <= width + 1; neighborWidth++) {
                        try {
                            if (lifeBoard[neighborLength][neighborWidth]) {
                                if (!(neighborLength == length && neighborWidth == width)) {
                                    ++neighborsCounter;
                                }
                            }
/*                        if (neighborLength >= 0 && neighborWidth >= 0 && neighborLength < lifeBoard.length && neighborWidth < lifeBoard[0].length && neighborLength != length && neighborWidth != width && lifeBoard[neighborLength][neighborWidth]) {
                            neighborsCounter++;*/
                        } catch (IndexOutOfBoundsException e) {continue;}
                    }
                }
                newBoard[length][width] = switch (neighborsCounter) {
                    case 0,1 -> false;
                    case 2 -> lifeBoard[length][width];
                    case 3 -> true;
                    default -> false;
                };
            }
        }
        return newBoard;
    }

    private static void drawLifeBoard(boolean[][] lifeBoard) {
        for (int length = 0; length < lifeBoard.length; length++) {
            for (int width = 0; width < lifeBoard[0].length; width++) {
                if (lifeBoard[length][width]) System.out.print("+");
                else System.out.print("#");
            }
            System.out.println();
        }
    }

    private static boolean[][] getNewBoard(int n, int m) {
        boolean[][] array = new boolean[n][m];
        Random rd = new Random();
        for (int length = 0; length < n; length++) {
            for (int width = 0; width < m; width++) {
                array[length][width] = rd.nextBoolean();
            }
        }
        return array;
    }
}

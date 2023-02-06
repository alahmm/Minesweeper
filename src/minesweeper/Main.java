package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] minesaround(char[][] matrix) {
        try {
            int counterX = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matrix[i][j] == '.') {
                        /**
                         * in the corner
                         */
                        if (i == 0 && j == 0) {
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == 'X') {
                                counterX ++;
                            }
                        } else if (i == 0 && j == 8) {
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == 'X') {
                                counterX ++;
                            }

                        } else if (i == 8 && j == 0) {
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == 'X') {
                                counterX ++;
                            }
                        } else if (i == 8 && j == 8) {
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == 'X') {
                                counterX ++;
                            }
                        }
                        /**
                         * on the side
                         */
                        else if (j == 0) {
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == 'X') {
                                counterX ++;
                            }
                        } else if (j == 8) {
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == 'X') {
                                counterX ++;
                            }
                        } else if (i == 0) {
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == 'X') {
                                counterX ++;
                            }
                        } else if (i == 8) {
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == 'X') {
                                counterX ++;
                            }
                        }
                        /**
                         * middel
                         */
                        else {
                            if (matrix[i - 1][j] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == 'X') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j] == 'X') {
                                counterX ++;
                            }
                        }

                    }
                    if (counterX != 0) {
                        char var = (char) (counterX + 48);
                        matrix[i][j] = var;
                        counterX = 0;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return matrix;
    }
    public static char[][] minesprovider(char[][] matrix, int number) {
        int counterX =0;
        Random random = new Random();
        while (counterX != number) {
            int line = random.nextInt(9);
            int column = random.nextInt(9);
            matrix[line][column] = 'X';
            counterX = counterX(matrix);
            }
        return matrix;
    }
    public static void printer(char[][] matrix) {
        System.out.println(" |123456789|\n" +
                "-|---------|");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 +"|");
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != 'X') {
                    System.out.print(matrix[i][j]);
                    } else {
                    System.out.print('.');
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-|---------|");
    }
    public static int counterX(char[][] matrix) {
        int counterX = 0;
        for (char[] array : matrix
        ) {
            for (char variable : array
            ) {
                if (variable == 'X') {
                    counterX ++;
                }
            }
        }
        return counterX;
    }
    public static void main(String[] args) {
        int counterStar = 0;
        char[][] matrixOfMines = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrixOfMines[i][j] = '.';
            }
        }
        System.out.print("How many mines do you want on the field?");
        Scanner scanner = new Scanner(System.in);
        int numberOfMines = scanner.nextInt();
        minesaround(minesprovider(matrixOfMines, numberOfMines));
        printer(matrixOfMines);
        while (true) {
            System.out.print("Set/delete mines marks (x and y coordinates): >");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            if (matrixOfMines[x - 1][y - 1] == 'X' || matrixOfMines[x - 1][y - 1] == '.') {
                if (matrixOfMines[x - 1][y - 1] == 'X') {
                    counterStar ++;
                }
                matrixOfMines[x - 1][y - 1] = '*';
                printer(matrixOfMines);
            } else if (matrixOfMines[x - 1][y - 1] == '*'){
                matrixOfMines[x - 1][y - 1] = '.';
                printer(matrixOfMines);
            }else {
                System.out.println("There is a number here!");
            }
            if (counterStar == numberOfMines) {
                System.out.println("Congratulations! You found all the mines!");
                return;
            }
        }

    }
}
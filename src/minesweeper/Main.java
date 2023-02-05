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
        for (char[] array : matrix
             ) {
            for (char variable : array
                 ) {
                System.out.print(variable);
            }
            System.out.println();
        }
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

        char[][] matrixOfMines = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrixOfMines[i][j] = '.';
            }
        }
        Scanner scanner = new Scanner(System.in);
        int numberOfMines = scanner.nextInt();
        printer(minesaround(minesprovider(matrixOfMines, numberOfMines)));

    }
}
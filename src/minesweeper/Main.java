package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
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
        printer(minesprovider(matrixOfMines, numberOfMines));

    }
}
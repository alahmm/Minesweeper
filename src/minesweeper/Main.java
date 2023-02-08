package minesweeper;

import java.util.Random;

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
    public static void printerLoss(char[][] matrix) {
        System.out.println(" |123456789|\n" +
                "-|---------|");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 +"|");
            for (int j = 0; j < 9; j++) {
                    System.out.print(matrix[i][j]);
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
}
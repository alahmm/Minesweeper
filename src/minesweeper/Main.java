package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] NoMinesAround(char[][] matrix, char var, int x, int y) {
        int counterX = 0;
        try {
            if (var == 'X') {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (matrix[i][j] == '.') {
                            /**
                             * in the corner
                             */
                            if (i == 0 && j == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j + 1] != var && matrix[i + 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 0 && j == 8) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8 && j == 0) {
                                if (matrix[i - 1][j] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8 && j == 8) {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i - 1][j - 1] != var) {
                                    counterX++;
                                }
                            }
                            /**
                             * on the side
                             */
                            else if (j == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var && matrix[i - 1][j] != var
                                        && matrix[i + 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (j == 8) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i - 1][j - 1] != var &&
                                        matrix[i - 1][j] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var &&
                                        matrix[i + 1][j + 1] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8) {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var &&
                                        matrix[i - 1][j + 1] != var && matrix[i - 1][j - 1] != var) {
                                    counterX++;
                                }
                            }
                            /**
                             * middel
                             */
                            else {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var
                                        && matrix[i - 1][j - 1] != var && matrix[i + 1][j + 1] != var && matrix[i + 1][j - 1] != var && matrix[i + 1][j] != var) {
                                    counterX++;
                                }
                            }
                        }
                        if (counterX != 0) {
                            matrix[i][j] = '/';
                            counterX = 0;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (matrix[i][j] != '.') {
                            /**
                             * in the corner
                             */
                            if (i == 0 && j == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j + 1] != var && matrix[i + 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 0 && j == 8) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8 && j == 0) {
                                if (matrix[i - 1][j] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8 && j == 8) {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i - 1][j - 1] != var) {
                                    counterX++;
                                }
                            }
                            /**
                             * on the side
                             */
                            else if (j == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var && matrix[i - 1][j] != var
                                        && matrix[i + 1][j + 1] != var) {
                                    counterX++;
                                }
                            } else if (j == 8) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i - 1][j - 1] != var &&
                                        matrix[i - 1][j] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 0) {
                                if (matrix[i + 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var &&
                                        matrix[i + 1][j + 1] != var && matrix[i + 1][j - 1] != var) {
                                    counterX++;
                                }
                            } else if (i == 8) {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var &&
                                        matrix[i - 1][j + 1] != var && matrix[i - 1][j - 1] != var) {
                                    counterX++;
                                }
                            }
                            /**
                             * middel
                             */
                            else {
                                if (matrix[i - 1][j] != var && matrix[i][j - 1] != var && matrix[i][j + 1] != var && matrix[i - 1][j + 1] != var
                                        && matrix[i - 1][j - 1] != var && matrix[i + 1][j + 1] != var && matrix[i + 1][j - 1] != var && matrix[i + 1][j] != var) {
                                    counterX++;
                                }
                            }
                        }
                        if (counterX != 0) {
                            if (i != x && j != y) {
                                matrix[i][j] = '.';
                            }
                            counterX = 0;
                        }
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return matrix;
    }

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
/*    public static char[][] NumbersRemover(char[][] matrix) {
        try {
            int counterX = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matrix[i][j] != '.' && matrix[i][j] != '/') {
                        *//**
                         * in the corner
                         *//*
                        if (i == 0 && j == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 0 && j == 8) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }

                        } else if (i == 8 && j == 0) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 8 && j == 8) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                        }
                        *//**
                         * on the side
                         *//*
                        else if (j == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (j == 8) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 8) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                        }
                        *//**
                         * middel
                         *//*
                        else {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                        }

                    }
                    if (counterX == 0) {

                            matrix[i][j] = '.';

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return matrix;
    }*/
    public static char[][] NumbersRemover(char[][] matrix, int x, int y) {
        try {
            int counterX = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matrix[i][j] != '.' && matrix[i][j] != '/') {
                        /**
                         * in the corner
                         */
                        if (i == 0 && j == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 0 && j == 8) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }

                        } else if (i == 8 && j == 0) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 8 && j == 8) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                        }
                        /**
                         * on the side
                         */
                        else if (j == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                        } else if (j == 8) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 0) {
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                        } else if (i == 8) {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                        }
                        /**
                         * middel
                         */
                        else {
                            if (matrix[i - 1][j] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i - 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j + 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j - 1] == '/') {
                                counterX ++;
                            }
                            if (matrix[i + 1][j] == '/') {
                                counterX ++;
                            }
                        }

                    }
                    if (counterX == 0) {
                        if (i != x && j != y) {
                            matrix[i][j] = '.';
                        }

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
    public static void printer(char[][] matrix, int x, int y) {
        System.out.println(" |123456789|\n" +
                "-|---------|");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 +"|");
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == '.' || matrix[i][j] == '/' || matrix[i][j] == '*') {
                    System.out.print(matrix[i][j]);
                } else if (matrix[i][j] == 'X'){
                    System.out.print('.');
                } else {
                   if (i == x && j == y) {
                       System.out.print(matrix[i][j]);
                   }
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
    public static void around(char[][] matrixOfPositions, int x, int y) {

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
        minesprovider(matrixOfMines, numberOfMines);
        printer(matrixOfMines);
        while (true) {
            System.out.print("Set/unset mines marks or claim a cell as free:");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String mode = scanner.next();
            if (mode.equals("mine")) {
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
            } else if (mode.equals("free")) {
                if (matrixOfMines[x - 1][y - 1] == 'X') {
                    System.out.println("You stepped on a mine and failed!");
                    return;
                } else {
                    NoMinesAround(matrixOfMines, 'X', - 1, - 1);
                    minesaround(matrixOfMines);
                    if (matrixOfMines[x - 1][y -1] == '/') {
                        NoMinesAround(matrixOfMines, '/', - 1, - 1);
                        //NumbersRemover(matrixOfMines);
                        printer(matrixOfMines);
                    } else {
                        //printer(matrixOfMines, x - 1, y - 1);

                        NoMinesAround(matrixOfMines, '/', x - 1, y - 1);
                        printer(matrixOfMines);
                    }

                }
            }

        }

    }
}
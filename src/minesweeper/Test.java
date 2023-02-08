package minesweeper;

import java.util.Scanner;

import static minesweeper.Main.*;

public class Test {
    static class Coordinates {
        int startI, startJ, endI, endJ;

        public Coordinates(int startI, int startJ, int endI, int endJ) {
            this.startI = startI;
            this.startJ = startJ;
            this.endI = endI;
            this.endJ = endJ;
        }
    }
    public static Coordinates determinerOfStartEnd(int x, int y) {
        int startI = x - 1;
        int startJ = y - 1;
        int endI = x + 1;
        int endJ = y + 1;
        if (x == 0) {
            startI = 0;
        } else if (x == 8) {
            endI = 8;
        }
        if (y == 0) {
            startJ = 0;
        } else if (y == 8) {
            endJ = 8;
        }
        return new Coordinates(startI, startJ, endI, endJ);
    }
    public static char[][] howManyXAround(char[][] matrixOfPositions, int x, int y, Coordinates coordinates) {
        int counterX = 0;
        if (matrixOfPositions[x][y] == '.') {
            for (int i = coordinates.startI; i <= coordinates.endI ; i++) {
                for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                    if (i != x || j != y) {
                        if (matrixOfPositions[i][j] == 'X') {
                            counterX ++;
                        }
                    }
                }
            }
            if (counterX != 0) {
                char var = (char) (counterX + 48);
                matrixOfPositions[x][y] = var;
            } else {
                matrixOfPositions[x][y] = '/';
            }
        }
        return matrixOfPositions;
    }
    public static char[][] ManyXAround(char[][] matrixOfPositions, Coordinates coordinates, int x, int y) {
        for (int i = coordinates.startI; i <= coordinates.endI; i++) {
            for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                 {
                    howManyXAround(matrixOfPositions, i, j, determinerOfStartEnd(i, j));
                }
            }
        }
        return matrixOfPositions;
    }
    public static char[][] howManyXAroundNext(char[][] matrixOfPositions, int x, int y, Coordinates coordinates) {
        ManyXAround(matrixOfPositions, coordinates, x, y);
        for (int i = coordinates.startI; i <= coordinates.endI; i++) {
            for (int j = coordinates.startJ; j <= coordinates.endJ; j++) {
                {
                    if (i != x || j != y) {
                        if (matrixOfPositions[i][j] == '/') {
                            ManyXAround(matrixOfPositions, determinerOfStartEnd(i, j), i, j);
                        }
                    }
                }
            }
        }
        return matrixOfPositions;
    }
    public static char[][] ControllerY(char[][] matrixOfPositions, int y, Coordinates coordinates) {
        for (int i = coordinates.startI; i <= coordinates.endI; i++) {
            if ( matrixOfPositions[i][y] == '/') {
                ManyXAround(matrixOfPositions, determinerOfStartEnd(i, y), i, y);
            }
        }
        return matrixOfPositions;
    }
    public static char[][] ControllerX(char[][] matrixOfPositions, int x, Coordinates coordinates) {
        for (int j = coordinates.startJ; j <= coordinates.endJ; j++) {
            if (matrixOfPositions[x][j] == '/') {
                ManyXAround(matrixOfPositions, determinerOfStartEnd(x, j), x, j);
            }
        }
        return matrixOfPositions;
    }
    public static void main(String[] args) {
        int counterSymbol = 0;
        int counterStar = 0;
        int counterPoint = 9 * 9;
        int counterNonPoint = 0;
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
                        counterPoint --;
                    }
                    matrixOfMines[x - 1][y - 1] = '*';
                    printer(matrixOfMines);
                } else if (matrixOfMines[x - 1][y - 1] == '*'){
                    matrixOfMines[x - 1][y - 1] = '.';
                    counterPoint ++;
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
                    printerLoss(matrixOfMines);
                    System.out.println("You stepped on a mine and failed!");
                    return;
                } else {
                    if (counterPoint == numberOfMines) {
                        printer(matrixOfMines);
                        System.out.println("Congratulations! You found all the mines!");
                        return;
                    }
                    char var = howManyXAround(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1))[x - 1][y - 1];
                    if ( var != '/') {
                        matrixOfMines[x - 1][y - 1] = var;
                        counterPoint --;
                        printer(matrixOfMines);
                    } else {
                        if (counterSymbol == 0) {
                            howManyXAroundNext(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1));

                            for (char[] array : matrixOfMines
                                 ) {
                                for (char variable : array
                                     ) {
                                    if (variable != '.') {
                                        counterNonPoint ++;
                                    }
                                }
                            }
                            counterPoint -= counterNonPoint;
                            printer(matrixOfMines);
                            counterSymbol ++;
                        } else {
                            howManyXAround(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1));
                            counterPoint --;
                            printer(matrixOfMines);
                        }

                    }
                }

                }
            }

        }

    }

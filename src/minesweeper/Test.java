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
    public static boolean isXAround(char[][] matrixOfPositions, int x, int y, Coordinates coordinates) {
        return howManyXAround(matrixOfPositions, x, y, coordinates)[x][y] != '/';
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
    public static char[][] howManyXAroundMore(char[][] matrixOfPositions, int x, int y, Coordinates coordinates) {
        ManyXAround(matrixOfPositions, coordinates, x, y);
/*        for (int i = coordinates.startI; i <= coordinates.endI; i++) {
            if (i != x && matrixOfPositions[i][y] == '/') {
                howManyXAroundMore(matrixOfPositions, i, y, determinerOfStartEnd(i, y));
            }
        }
        for (int j = coordinates.startJ; j <= coordinates.endJ; j++) {
            if (j != y && matrixOfPositions[x][j] == '/') {
                howManyXAroundMore(matrixOfPositions, x, j, determinerOfStartEnd(x, j));
            }
        }*/
        if (x < 8 && matrixOfPositions[x + 1][y] == '/') {
            coordinates = determinerOfStartEnd(x + 1, y);
            for (int i = coordinates.startI; i <= coordinates.endI ; i++) {
                for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                    if (matrixOfPositions[i][j] == '.') {
                        howManyXAroundMore(matrixOfPositions, x + 1, y, determinerOfStartEnd(x + 1, y));
                    }
                }
            }
            }
            if (x > 0 && matrixOfPositions[x - 1][y] == '/') {
                coordinates = determinerOfStartEnd(x - 1, y);
                for (int i = coordinates.startI; i <= coordinates.endI ; i++) {
                    for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                        if (matrixOfPositions[i][j] == '.') {
                            howManyXAroundMore(matrixOfPositions, x - 1, y, determinerOfStartEnd(x - 1, y));
                        }
                    }
                }
            }
            if (y < 8 && matrixOfPositions[x][y + 1] == '/') {
                coordinates = determinerOfStartEnd(x , y + 1);
                for (int i = coordinates.startI; i <= coordinates.endI ; i++) {
                    for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                        if (matrixOfPositions[i][j] == '.') {
                            howManyXAroundMore(matrixOfPositions, x, y + 1, determinerOfStartEnd(x, y + 1));
                        }
                    }
                }
            }
            if (y > 0 && matrixOfPositions[x][y - 1] == '/') {
                coordinates = determinerOfStartEnd(x, y - 1);
                for (int i = coordinates.startI; i <= coordinates.endI ; i++) {
                    for (int j = coordinates.startJ; j <= coordinates.endJ ; j++) {
                        if (matrixOfPositions[i][j] == '.') {
                            howManyXAroundMore(matrixOfPositions, x, y - 1, determinerOfStartEnd(x, y - 1));
                        }
                    }
                }
            }

        return matrixOfPositions;
    }
    public static void main(String[] args) {
        int counterSymbol = 0;
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
                    printerLoss(matrixOfMines);
                    System.out.println("You stepped on a mine and failed!");
                    return;
                } else {
                    char var = howManyXAround(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1))[x - 1][y - 1];
                    if ( var != '/') {
                        matrixOfMines[x - 1][y - 1] = var;
                        printer(matrixOfMines);
                    } else {
                        if (counterSymbol == 0) {
                            howManyXAroundMore(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1));
                            printer(matrixOfMines);
                            counterSymbol ++;
                        } else {
                            howManyXAround(matrixOfMines, x - 1, y - 1, determinerOfStartEnd(x - 1, y - 1));
                            printer(matrixOfMines);
                        }

                    }
                }

                }
            }

        }

    }

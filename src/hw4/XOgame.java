package hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XOgame {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {

        initMap();
        printMap();

        int count = 0;

        while (true) {
            humanTurn();

            if (checkWin(DOT_X)) {
                printMap();
                System.out.println("Ты победил! ");
                break;
            }

            count++;

            if (isFull(count)) {
                printMap();
                System.out.println("Ничья!");
                break;
            }

            aiTurn();

            if (checkWin(DOT_O)) {
                printMap();
                System.out.println("Компьютер победил! ");
                break;
            }

            count++;

            if (isFull(count)) {
                printMap();
                System.out.println("Ничья!");
                break;
            }

            printMap();

        }
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Input X, Y ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;

        char c = DOT_X;

        //ищет от DOTS_TO_WIN - 1 до 2 крестиков подряд
        for (int l = DOTS_TO_WIN - 1; l >= 2; l--) {

            for (int i = 0; i < SIZE; i++) {

                int vert = 0;
                int horiz = 0;

                for (int j = 0; j < SIZE; j++) {

                    if (map[i][j] == c) {
                        vert++;
                    } else {
                        vert = 0;
                    }

                    if (vert >= l) {
                        if (j < SIZE - 1 && isCellValid(i, j + 1)) {
                            map[i][j + 1] = DOT_O;
                            return;
                        } else if (j - vert >= 0 && isCellValid(i, j - vert)) {
                            map[i][j - vert] = DOT_O;
                            return;
                        }
                    }

                    if (map[j][i] == c) {
                        horiz++;
                    } else {
                        horiz = 0;
                    }

                    if (horiz >= l) {

                        if (j < SIZE - 1 && isCellValid(j + 1, i)) {
                            map[j + 1][i] = DOT_O;
                            return;
                        } else if (j - horiz >= 0 && isCellValid(j - horiz, i)) {
                            map[j - horiz][i] = DOT_O;
                            return;
                        }
                    }

                }

                int leftDiagonal1 = 0;
                int leftDiagonal2 = 0;
                int rightDiagonal1 = 0;
                int rightDiagonal2 = 0;

                for (int j = 0; j < SIZE - i; j++) {

                    if (map[j + i][j] == c) {
                        leftDiagonal1++;
                    } else {
                        leftDiagonal1 = 0;
                    }

                    if (leftDiagonal1 >= l) {
                        if (j < SIZE - 1 && isCellValid(j + i + 1, j + 1)) {
                            map[j + i + 1][j + 1] = DOT_O;
                            return;
                        } else if (j - leftDiagonal1 >= 0 && isCellValid(j + i - leftDiagonal1, j - leftDiagonal1)) {
                            map[j + i - leftDiagonal1][j - leftDiagonal1] = DOT_O;
                            return;
                        }
                    }

                    if (map[j][j + i] == c) {
                        leftDiagonal2++;
                    } else {
                        leftDiagonal2 = 0;
                    }

                    if (leftDiagonal2 >= l) {
                        if (j < SIZE - 1 && isCellValid(j + 1, j + i + 1)) {
                            map[j + 1][j + i + 1] = DOT_O;
                            return;
                        } else if (j - leftDiagonal2 >= 0 && isCellValid(j - leftDiagonal2, j + i - leftDiagonal2)) {
                            map[j - leftDiagonal2][j + i - leftDiagonal2] = DOT_O;
                            return;
                        }
                    }

                    if (map[SIZE - 1 - i - j][j] == c) {
                        rightDiagonal1++;
                    } else {
                        rightDiagonal1 = 0;
                    }

                    if (rightDiagonal1 >= l) {
                        if (j < SIZE - 1 && isCellValid(SIZE - 1 - i - j - 1, j + 1)) {
                            map[SIZE - 1 - i - j - 1][j + 1] = DOT_O;
                            return;
                        } else if (j - rightDiagonal1 >= 0 && isCellValid(SIZE - 1 - i - j + rightDiagonal1, j - rightDiagonal1)) {
                            map[SIZE - 1 - i - j + rightDiagonal1][j - rightDiagonal1] = DOT_O;
                            return;
                        }
                    }

                    if (map[SIZE - 1 - j][j + i] == c) {
                        rightDiagonal2++;
                    } else {
                        rightDiagonal2 = 0;
                    }

                    if (rightDiagonal2 >= l) {
                        if (j < SIZE - 1 && isCellValid(SIZE - 1 - j - 1, j + i + 1)) {
                            map[SIZE - 1 - j - 1][j + i + 1] = DOT_O;
                            return;
                        } else if (j - rightDiagonal2 >= 0 && isCellValid(SIZE - 1 - j + rightDiagonal2, j + i - rightDiagonal2)) {
                            map[SIZE - 1 - j + rightDiagonal2][j + i - rightDiagonal2] = DOT_O;
                            return;
                        }
                    }
                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isFull(int count) {
        return count == SIZE * SIZE;
    }

    public static boolean checkWin(char c) {

        for (int i = 0; i < SIZE; i++) {

            int horizontal = 0;
            int vertical = 0;

            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == c) {
                    horizontal++;
                } else {
                    horizontal = 0;
                }

                if (map[j][i] == c) {
                    vertical++;
                } else {
                    vertical = 0;
                }

                if (horizontal >= DOTS_TO_WIN || vertical >= DOTS_TO_WIN) {
                    return true;
                }

            }

            int leftDiagonal1 = 0;
            int leftDiagonal2 = 0;
            int rightDiagonal1 = 0;
            int rightDiagonal2 = 0;

            if(SIZE - i >= DOTS_TO_WIN) {
                for (int j = 0; j < SIZE - i; j++) {

                    if (map[j + i][j] == c) {
                        leftDiagonal1++;
                    } else {
                        leftDiagonal1 = 0;
                    }

                    if (map[j][j + i] == c) {
                        leftDiagonal2++;
                    } else {
                        leftDiagonal2 = 0;
                    }

                    if (map[SIZE - 1 - i - j][j] == c) {
                        rightDiagonal1++;
                    } else {
                        rightDiagonal1 = 0;
                    }

                    if (map[SIZE - 1 - j][j + i] == c) {
                        rightDiagonal2++;
                    } else {
                        rightDiagonal2 = 0;
                    }

                    if(leftDiagonal1 >= DOTS_TO_WIN || leftDiagonal2 >= DOTS_TO_WIN || rightDiagonal1 >= DOTS_TO_WIN || rightDiagonal2 >= DOTS_TO_WIN){
                        return true;
                    }
                }

            }

        }

        return false;
    }

}

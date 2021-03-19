package Package01.Package02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static char [][] map;
    public static char [] check;
    public static char [] checkNew;
    public static char [] checkNew1;
    public static char [] checkNew2;
    public static char [] checkNew3;
    public static char [] checkNew4;
    public static char [] checkNew5;
    public static char [] checkNew6;
    public static char [] checkNew7;

    public static char [] checkPC;
    public static char [] checkPC1;
    public static char [] checkPC2;
    public static char [] checkPC3;
    public static char [] checkPC4;
    public static char [] checkPC5;
    public static char [] checkPC6;
    public static char [] checkPC7;
    public static char [] checkPC8;

    public static int mapSizeX = 3;
    public static int mapSizeY = 3;


    public static char human = 'X';
    public static char ai = '0';
    public static char empty = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random  = new Random();

    public static void myMap(int sizeY, int sizeX) {
        map = new char[sizeY][sizeX];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void checkWin (int sizeX) {
        check = new char [sizeX];
        for (int x = 0; x < sizeX; x++){
            check[x] = human;
        }
    }

    public static void checkWinPC (int sizeX) {
        checkPC = new char [sizeX];
        for (int x = 0; x < sizeX; x++){
            checkPC[x] = ai;
        }
    }

    public static void checkNewWin (int sizeX) {
        checkNew = new char [sizeX];

        for (int i = 0; i < sizeX; i++) {
            checkNew[i] = map[i][i];
        }

        checkNew1 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew1[i] = map[i][(mapSizeX -1) - i];
        }

        checkNew2 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew2[i] = map[0][i];
        }

        checkNew3 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew3[i] = map[i][0];
        }

        checkNew4 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew4[i] = map[mapSizeX - 1][i];
        }

        checkNew5 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew5[i] = map[i][mapSizeX - 1];
        }

        checkNew6 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew6[i] = map[1][i];
        }

        checkNew7 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkNew7[i] = map[i][1];
        }
    }

    public static void checkNewWinPC (int sizeX) {

        checkPC1 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC1[i] = map[i][i];
        }

        checkPC2 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC2[i] = map[i][(mapSizeX -1) - i];
        }

        checkPC3 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC3[i] = map[0][i];
        }

        checkPC4 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC4[i] = map[i][0];
        }

        checkPC5 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC5[i] = map[mapSizeX - 1][i];
        }

        checkPC6 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC6[i] = map[i][mapSizeX - 1];
        }

        checkPC7 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC7[i] = map[1][i];
        }

        checkPC8 = new char [sizeX];
        for (int i = 0; i < sizeX; i++) {
            checkPC8[i] = map[i][1];
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void humanStep(){
        int x;
        int y;

        do {
            System.out.println("Enter your coordinates: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidStep(y, x) || !isEmptyCell(y, x));
        map[y][x] = human;
        System.out.println("Your step in" + y +":" + x);
    }

    public static void stepPC(){
        int x;
        int y;

        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!isEmptyCell(y,x));
        map[y][x] = ai;
        System.out.println("AI step in" + y +":" + x);
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;
    }

   /* public static boolean checkWinLine(char player) {
        if (map[0][0] == player && map[0][1] == player && map[0][2] == player) return true;
        if (map[1][0] == player && map[1][1] == player && map[1][2] == player) return true;
        if (map[2][0] == player && map[2][1] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][0] == player && map[2][0] == player) return true;
        if (map[0][1] == player && map[1][1] == player && map[2][1] == player) return true;
        if (map[0][2] == player && map[1][2] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;

        return false;
    }*/

    public static boolean isValidStep(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == empty;
    }

    public static void main(String[] args) {
        myMap(mapSizeY, mapSizeX);
        checkWin (mapSizeX);
        printMap();

        while (true) {
            humanStep();
            printMap();
            checkNewWin(mapSizeX);
            checkNewWinPC(mapSizeX);

            if (Arrays.equals(check, checkNew)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew1)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew2)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew3)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew4)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew5)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew6)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(check, checkNew7)){
                System.out.println("Human win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC1)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC2)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC3)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC4)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC5)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC6)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC7)){
                System.out.println("AI win!");
                break;
            }

            if (Arrays.equals(checkPC, checkPC8)){
                System.out.println("AI win!");
                break;
            }



            if (isFullMap()){
                System.out.println("Draw!");
                break;
            }

            stepPC();
            printMap();

           /* if (checkWinLine(ai)){
                System.out.println("AI win!");
                break;
            }*/

            if (isFullMap()){
                System.out.println("Draw!");
                break;
            }
        }
    }
}

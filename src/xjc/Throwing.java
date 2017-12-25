package xjc;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Xin Jet Chew on 21-Mar-17.
 */
public abstract class Throwing {

    static final double GRAVITATIONAL_ACC = 9.80665;

    private static final int FPS = 144;

    static Scanner SC = new Scanner(System.in);

    static int gridWidth = 400;
    static int gridHeight = 200;


    protected static void display(int[][] array, Graphics g) {
        int BOX_WIDTH = 10;
        int BOX_HEIGHT = 10;
        Random rnd = new Random();
        Color[] colorArray = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED, Color.WHITE};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                g.setColor(array[i][j] == 0 ? Color.BLACK : colorArray[rnd.nextInt(colorArray.length - 1)]);
                g.fillRect(j * BOX_WIDTH, i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
            }
        }
    }

    static int getFPS() {
        return (int) (Math.pow(FPS, -1) * 1000);
    }

    static double getTimePassed(long startTime) {
        return (System.nanoTime() - startTime) * Math.pow(10, -9);
    }

    static double getInitVelocity() {
        System.out.print("Enter initial velocity: ");
        return SC.nextDouble();
    }

    static int[][] updateGrid(int[][] grid, int y, int x) {
        grid = new int[gridHeight][gridWidth];
        grid[gridHeight - (y + 1)][x] = 1;
        return grid;
    }

    static int[][] updateGrid2(int[][] grid, int y, int x) {
        grid[gridHeight - (y + 1)][x] = 1;
        return grid;
    }

    protected static void clear() {
        System.out.print(String.format("\033[H\033[2J"));
    }

    protected static void printGrid(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                switch (array[i][j]) {
                    case 0:
                        System.out.print("  ");
                        break;
                    case 1:
                        System.out.print("H ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String round2(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(value);
    }

    static String formatted(String type, double value, String unit) {
        return type + ": " + round2(value) + unit;
    }
}

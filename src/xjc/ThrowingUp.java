package xjc;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Xin Jet Chew on 21-Mar-17.
 */
public class ThrowingUp extends Throwing {

    private static int gridWidth = 3;

    public static void main(String[] args) throws InterruptedException, IOException {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(100, 1039);
        Container contentPane = frame.getContentPane();
        contentPane.add(panel);
        frame.setVisible(true);
        boolean flag = true;
        boolean end = true;
        int[][] grid = new int[gridWidth][gridHeight];
        double initVelocity = getInitVelocity();
        double displacement;
        double timePassed;
        long startTime;

        do {
            startTime = System.nanoTime();
            do {
                Thread.sleep(getFPS());
                timePassed = getTimePassed(startTime);
                displacement = Physics.calcDisplacement(initVelocity, timePassed, -GRAVITATIONAL_ACC);
                if (displacement >= 0) {
                    grid = updateGrid(grid, (int) displacement, gridWidth / 2);
                    Graphics g = panel.getGraphics();
                    display(grid, g);
                    System.out.flush();
                    System.out.print("\r" + formatted("Height", displacement, "m") + " " + formatted("Velocity", Physics.calcVelocity(initVelocity, -GRAVITATIONAL_ACC, displacement), "ms⁻¹") + " " + formatted("Time passed", timePassed, "s"));
                } else {
                    flag = false;
                }
            } while (flag);
            flag = true;
        } while (end);
    }

    public static void display(int[][] array, Graphics g) {
        int BOX_WIDTH = 40;
        int BOX_HEIGHT = 5;
        Random rnd = new Random();
        Color[] colorArray = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED, Color.WHITE};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                g.setColor(array[i][j] == 0 ? Color.BLACK : colorArray[rnd.nextInt(colorArray.length - 1)]);
                g.fillRect(j * BOX_WIDTH, i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
            }
        }
    }

}

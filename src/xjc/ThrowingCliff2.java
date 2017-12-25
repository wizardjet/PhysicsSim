package xjc;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Xin Jet Chew on 22-Mar-17.
 */
public class ThrowingCliff2 extends Throwing {

    public static void main(String[] args) throws InterruptedException, IOException {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(2078, 1039);
        Container contentPane = frame.getContentPane();
        contentPane.add(panel);
        frame.setVisible(true);
        boolean flag = true;
        boolean end = true;
        int[][] grid = new int[gridWidth][gridHeight];

        //Horizontal component
        double hInitVelocity = getInitVelocity();
        double hDisplacement;
        //Vertical component
        double height = getHeight();
        double vDisplacement;

        //Horizontal component 2
        double hInitVelocity2 = getInitVelocity();
        double hDisplacement2;
        //Vertical component 2
        double height2 = getHeight();
        double vDisplacement2;

        double timePassed;
        long startTime;

        do {
            startTime = System.nanoTime();
            do {
                Thread.sleep(getFPS());
                timePassed = getTimePassed(startTime);
                hDisplacement = Physics.calcDisplacement(hInitVelocity, timePassed, 0);
                vDisplacement = height - Physics.calcDisplacement(0, timePassed, GRAVITATIONAL_ACC);
                hDisplacement2 = Physics.calcDisplacement(hInitVelocity2, timePassed, 0);
                vDisplacement2 = height2 - Physics.calcDisplacement(0, timePassed, GRAVITATIONAL_ACC);
                if (vDisplacement >= 0 & vDisplacement2 >= 0) {
                    grid = updateGrid2(updateGrid(grid, (int) vDisplacement, (int) hDisplacement), (int) vDisplacement2, (int) hDisplacement2);
                    Graphics g = panel.getGraphics();
                    display(grid, g);
//                    System.out.flush();
//                    System.out.print("\r" + formatted("Height", vDisplacement, "m") + " " + formatted("Velocity", Physics.calcVelocity(0, GRAVITATIONAL_ACC, height - vDisplacement), "ms⁻¹") + " " + formatted("Time passed", timePassed, "s"));
                } else {
//                    System.out.print(formatted("Height", vDisplacement, "m") + " " + formatted("Velocity", Physics.calcVelocity(0, GRAVITATIONAL_ACC, vDisplacement), "ms⁻¹") + " " + formatted("Time passed", timePassed, "s"));
                    flag = false;
                }
            } while (flag);
            flag = true;
        } while (end);
    }

    public static void display(int[][] array, Graphics g) {
        int BOX_WIDTH = 5;
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

    private static double getHeight() {
        System.out.print("Enter initial height: ");
        return SC.nextDouble();
    }

}

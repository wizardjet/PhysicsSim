package xjc;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double time;
        double distance;
        double iVelocity;
        double fVelocity;
        System.out.print("Select an option:\n1. Calculate velocity (time and distance)\n2. Calculate acceleration (initial velocity, final velocity and time)\nOption: ");
        switch (sc.nextInt()) {
            case 1:
                distance = getDistance();
                time = getTime();
                System.out.println(Physics.calcVelocity(time,distance).formatted());
                break;
            case 2:
                iVelocity = getVelocity("initial");
                fVelocity = getVelocity("final");
                time = getTime();


        }
    }

    public static double getVelocity(String mode) {
        switch (mode) {
            case "initial":
                System.out.print("Enter initial velocity(ms⁻¹): ");
                break;
            case "final":
                System.out.print("Enter final velocity(ms⁻¹): ");
                break;
        }
        return sc.nextDouble();
    }

    public static double getTime() {
        System.out.print("Enter time(s): ");
        return sc.nextDouble();
    }

    public static double getDistance() {
        System.out.print("Enter distance(m): ");
        return sc.nextDouble();
    }
}

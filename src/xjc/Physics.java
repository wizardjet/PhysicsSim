package xjc;

/**
 * Created by WizardJet on 16/03/2017.
 */
public class Physics {

    public static final String TYPE_VELOCITY = "Velocity";
    public static final String UNIT_VELOCITY = "ms⁻¹";
    public static final String TYPE_DISPLACEMENT = "Displacement";
    public static final String UNIT_DISPLACEMENT = "m";

    public static void main(String[] args) {
        System.out.println(calcDisplacement(5, 10, -9.81));
    }


    public static PhysicsUnit calcVelocity(double time, double distance) {
        //Time in seconds
        //Distance in meters
        return new PhysicsUnit(TYPE_VELOCITY, distance / time, UNIT_VELOCITY);
    }

    public static double calcDisplacement(double u, double t, double a) {
        return u*t + 0.5 * (a * Math.pow(t, 2));
    }

//    public static double calcVelocity(double u, double a, double t) {
//        return u + a * t;
//    }

    public static double calcVelocity(double u, double a, double s) {
        return Math.pow(Math.pow(u,2) + 2 * a * s, 0.5);
    }

}

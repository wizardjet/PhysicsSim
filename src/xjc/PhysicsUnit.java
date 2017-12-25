package xjc;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by WizardJet on 16/03/2017.
 */
public class PhysicsUnit {

    private String type;
    private double rawValue;
    private String roundValue;
    private String unit;

    public PhysicsUnit(String type, double rawValue, String unit) {
        this.type = type;
        this.rawValue = rawValue;
        this.unit = unit;
    }

    public void round2() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        roundValue = df.format(rawValue);
    }

    public String formatted() {
        round2();
        return type + ": " + roundValue + unit;
    }

    public double getValue() {
        return rawValue;
    }

}

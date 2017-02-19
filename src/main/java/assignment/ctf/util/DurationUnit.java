package assignment.ctf.util;


/**
 * Created by user on 2/17/2017.
 */
public enum DurationUnit {
    MIN(1, "min"),
    LIGHTNING(5, "lightning");

    private int baseUnit;
    private String representation;

    DurationUnit(int baseUnit, String representation) {
        this.baseUnit = baseUnit;
        this.representation = representation;
    }

    public int getBaseUnit() {
        return this.baseUnit;
    }

    public String getRepresentation() {
        return representation;
    }

    public static DurationUnit getDurationUnit(String value) {

        if (value.equalsIgnoreCase("min")) {
            return DurationUnit.MIN;
        } else if (value.equalsIgnoreCase("lightning")) {
            return DurationUnit.LIGHTNING;
        }

        throw new IllegalArgumentException("The value to be converted should either be in mins or lightning");

    }
}

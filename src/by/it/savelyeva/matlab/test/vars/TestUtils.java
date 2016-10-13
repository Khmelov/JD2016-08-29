package by.it.savelyeva.matlab.test.vars;

/**
 * Created by nato on 10/12/16.
 */
public class TestUtils {

    private static final double precision = 0.1e-9;

    private static int compareDoublesWithPrecision(double a, double b, double precision) {
        double difference = a - b;
        if (Math.abs(difference) < precision) return 0;
        else if (difference > 0) return 1;
        else return -1;
    }

    public static boolean doublesEqual(Double a, Double b) {
        return compareDoublesWithPrecision(a, b, precision) == 0;
    }

    public static boolean vectorsEqual(double[] aValues, double[] bValues) {
        if (aValues.length != bValues.length) return false;
        int i = 0;
        while (i < aValues.length) {
            if (!doublesEqual(aValues[i], bValues[i])) return false;
            i++;
        }
        return true;
    }

    public static boolean matricesEqual(double[][] aValues, double[][] bValues) {
        if (aValues.length != bValues.length && aValues[0].length != bValues[0].length) {
            return false;
        }
        int i = 0;
        while (i < aValues.length) {
            int j = 0;
            while (j < aValues[0].length) {
                if (!doublesEqual(aValues[i][j], bValues[i][j])) return false;
                j++;
            }
            i++;
        }
        return true;

    }

}
package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task2 {

    public static double calculateY(double a, double b) {
        return Math.pow(1/Math.tan(Math.PI/4 - 1), 4)
                + Math.pow(a + 1.5, 1/3)
                - b / Math.asin(Math.pow(a, 2)); // Math.pow(Math.abs(a),2) === Math.pow(a, 2)
    }

}

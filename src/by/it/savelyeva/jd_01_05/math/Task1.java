package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task1 {
    public static double partsCalculateY(double x) {
        double y;
        double sinArg2, root4, lg3, arcsin, num;
        double numerator, denominator;
        sinArg2 = Math.sin(Math.pow(Math.PI/6 - 1, 2));
        root4 = Math.pow((3 + x*x), 0.25);
        lg3 = Math.pow(Math.log10(Math.pow(x,3) - 1), 3);
        arcsin = Math.asin(x/2);
        num = 1.756 * Math.pow(10, -2);
        numerator = sinArg2 + root4 - lg3;
        denominator = arcsin - num;
        y = numerator / denominator;
        return y;
    }

    public static double fullCalculateY(double x) {
        return (Math.sin(Math.pow(Math.PI/6 - 1, 2))
                + Math.pow((3 + x*x), 0.25)
                - Math.pow(Math.log10(Math.pow(x,3) - 1), 3)
        ) / (Math.asin(x/2) - 1.756 * Math.pow(10, -2));
    }

}

package by.it.sukora.JD1_05.Math;

/**
 * Created by stasi on 12.09.2016.
 */
public class Task4 {

    public static double yravnenie(double a){
        double sum = 0;

        for (double b = 0.2; b <= 0.4; b += 0.02){
            for (int c = 1; c <= 12; c++){
                double x = c + b;
                sum += x;

            }

        }
        Math.pow(sum,2);
        return 1.38 - a + sum;
    }

}

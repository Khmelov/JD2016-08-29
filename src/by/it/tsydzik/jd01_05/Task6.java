package by.it.tsydzik.jd01_05;

/**
 * Created by user on 12.09.2016.
 */
public class Task6 {
    public static void compute() {
        int dimension = 35;
        double start = 0;
        double end = 7;

        double[] array = new double[dimension];
        double step = end / dimension;
        double result;

        for (int i = 0; i < array.length; i++) {
            result = start + Math.sin(start);
            array[i] = result;
            if (result > 3) {
                System.out.println("index = " + i + ": elem = " + array[i]);
            }
            start += step;
        }
    }
}

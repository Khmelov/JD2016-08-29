package by.it.laurynovich.jd01_13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vseotdala on 9/26/2016.
 */
public class TaskA {
    public static void main(String[] args) {
        String line;
        double sum = 0;
        //List<Double> mas = new ArrayList<>();
        while (!(line = Util.oneLine()).equals("END")) {
            try {
                double value = Double.valueOf(line.trim());
                if (value > 0) {
                    ArithmeticException e = new ArithmeticException("отрицательное число");
                    throw e;

                }
                sum = sum + Math.sqrt(value);
                System.out.flush();
                System.out.println("Value = " + value + "Sum = " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Exception number " + line);
            } catch (ArithmeticException e) {

                System.out.println("Exception number " + line);
            }
        }
    }
}

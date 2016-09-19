package by.it.grishechkin.jd01_05;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task6 {

    public static double calc(double x) {
        return log(abs(x - 12));
    }

    public static void printArr(double[] arr) {
        System.out.println("\tindex\t  value");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\t%1$2d \t\t%2$+5.3f", i + 1, arr[i]);
            System.out.println();
        }
    }

    public static void mean(double [] arr) {
        System.out.println("\tindex\t  sum");
        for (int i = 9; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            double mean = sum/10;
            System.out.printf("\t%1$2d \t\t%2$+5.3f", i + 1, sum);
            System.out.println();
        }
    }

    public static void mod3(double[] arr) {
        int iter = 0;
        for (int i = 0; i < arr.length; i++) {
            if((i+1) % 3 == 0) {
                iter++;
            }
        }

        double [] newArr = new double[iter];
        System.out.println("\tindex\t  new elem");
        for (int i = 0, j = 0; i < arr.length; i++) {
            if((i+1) % 3 == 0) {
                newArr[j] = arr[i];
                System.out.printf("\t%1$2d \t\t%2$+5.3f", i+1, newArr[j]);
                System.out.println();
                j++;
            }
        }
    }


}

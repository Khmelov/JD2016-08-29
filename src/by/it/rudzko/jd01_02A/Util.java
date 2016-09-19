package by.it.rudzko.jd01_02A;

import java.util.Scanner;

/**
 * Created by Kir on 01.09.2016.
 */
public class Util {
    public static String getNumbers() {
        String x;
        Scanner scan = new Scanner(System.in);
        x = scan.nextLine();
        return x;
    }

    public static int[] createAr(String entered) {
        String a[] = entered.split("/");
        int y[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            y[i] = Integer.parseInt(a[i]);
        }
        return y;

    }

    static public void printArray(int[] mas) {

            for (int value: mas) {
            System.out.print(value + "  ");
        }

    }
}

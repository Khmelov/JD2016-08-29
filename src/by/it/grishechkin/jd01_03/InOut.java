package by.it.grishechkin.jd01_03;

import java.util.Scanner;

/**
 * Created by Yury on 02.09.2016.
 */
public class InOut {

    static String consoleReadLine () {
        return new Scanner(System.in).nextLine();
    }

    static double [] arrayFromString(String str) {
        str = str.trim();
        String strArray [] = str.split(" ");
        double res[] = new double[strArray.length];

        for (int i = 0; i < strArray.length ; i++) {
            res[i] = Double.parseDouble(strArray[i]);
        }
        return res;
    }

    static void arrayPrint(double mas[], String name, int cols) {
        int col = 0;
        for (double value : mas) {
            System.out.printf(name + "[% -3d]=%-6.2f", col, mas[col]);
            col++;
            if(col%cols==0)
                System.out.println();
        }
    }
}

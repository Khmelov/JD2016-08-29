package by.it.savelyeva.jd_01_04;

import java.util.Scanner;

/**
 * Created by nato on 9/2/16.
 */
public class InOut {
    public static String consoleReadLine() {
        return new Scanner(System.in).nextLine();
    }

    public static double[] arrayFromString(String line) {
        String[] strMas = line.split(" ");
        double[] doubleMas = new double[strMas.length];
        for (int i=0; i<strMas.length; i++) {
            doubleMas[i] = Double.parseDouble(strMas[i]);
        }
        return doubleMas;
    }

    public static void arrayPrint(double[] mas) {
        for (double value: mas) {
            System.out.printf("%-6.2f ", value);
        }
        System.out.println();
    }

    public static void arrayPrint(double[] mas, String name, int cols) {
        int col = 0;
        for (double value: mas) {
            System.out.printf(name + "[% -3d]=%-6.2f",col,mas[col]);
            col++;
            if (col%cols==0) System.out.println();
        }
        System.out.println();
    }

    public static void arrayPrint2D(double[][] m) {
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++)
                System.out.printf("%6.2f ", m[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static void arrayPrint2D(double[][] m, String name) {
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++)
                System.out.printf(name + "[%1d,%1d]=%-6.1f ", i, j, m[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}




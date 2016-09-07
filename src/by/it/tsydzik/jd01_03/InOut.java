package by.it.tsydzik.jd01_03;

import java.util.Scanner;

public class InOut {
    public static String consoleReadLine() {
        return new Scanner(System.in).nextLine();
    }

    public static double[] arrayFromString(String line) {
        String[] strMas = line.split(" ");
        double[] doubleMas = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            doubleMas[i] = Double.parseDouble(strMas[i]);
        }
        return doubleMas;
    }

    public static void arrayPrint(double mas[], String name, int cols) {
        int col = 0;
        for (double value : mas) {
            System.out.printf(name + "[% -3d]=%-8.2f", col, mas[col]);
            col++;
            if (col % cols == 0) System.out.println();
        }

    }
}




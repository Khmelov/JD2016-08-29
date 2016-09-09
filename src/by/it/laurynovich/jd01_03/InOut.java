package by.it.laurynovich.jd01_03;

import java.util.Scanner;

/**
 * Created by vseotdala on 02.09.2016.
 */
public class InOut {
    private static double[] mas;
    private static String name;
    private static int cols;

    public static String consoleReadLine(){
        return new Scanner(System.in ).nextLine();
    }

    static double[] arrayFromString(String str){
        str=str.trim();
        String strArray[]=str.split(" ");
        double res[]=new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res[i]=Double.parseDouble( strArray[i] );

        }
        return res;

    }
    static void arrayPrint (double mas[],String name, int cols){
        InOut.mas = mas;
        InOut.name = name;
        InOut.cols = cols;
        int col=0;
        for (double value:mas){
            System.out.printf ( name + "[ %-2d]=%-6.1f", col, mas[col] );
            col++;
            if (col%cols==0 || col == mas.length-1) {
                System.out.println();
            }
        }
    }
}


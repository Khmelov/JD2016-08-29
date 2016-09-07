package by.it.opashniuk.jd01_03;

import java.util.Scanner;

public class InOut {
    static String consoleReadLine() {
        return new Scanner(System.in).nextLine();
    }
    static double[] arrayFromString(String str) {
        String strArray[]=str.split(" ");
        int count=strArray.length;
        double res[]=new double[strArray.length];
        for (int i=0; i<strArray.length; i++) {
            res[i]=Double.parseDouble(strArray[i]);
        }
        return res;
    }
    static void arrayPrint(double mas[],String name,int cols) {
        int col=0;
        for (double value:mas) {
            System.out.printf(name+"[%-3d]=%-6.2f ",col,mas[col]);
            col++;
            if (col%col==0 || col==mas.length-1)
                System.out.println();

        }
    }

}

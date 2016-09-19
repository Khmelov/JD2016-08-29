package by.it.senchenko.jd01_04;

/**
 * Created by User on 05.09.2016.
 */

public class InOut {
    static void arrayPrint(double mas[],String name,int cols) {
        int col=0;
        for (double value:mas) {
            System.out.printf(name+"[%-3d]=%-6.2f ",col,mas[col]);
            col++;
            if (col%col==0 || col==mas.length-1)
                System.out.println();

        }
    }

    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf("%6.2f ",m[i][j]);
             System.out.println();
            }
        System.out.println();
    }

    public static void arrayPrint2D(double[][] m, String name){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf(name+"[%1d,%1d]=%-6.1f ", i, j, m[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}

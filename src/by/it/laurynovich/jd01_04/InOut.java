package by.it.laurynovich.jd01_04;

/**
 * Created by vseotdala on 05.09.2016.
 */
public class InOut {
    public static void printArr(double[][] m){
        for (int i = 0 ; i < m.length; i++) {
            for (int j = 0; j <m[0].length ; j++) {
                System.out.printf("%-6.2f ",m[i][j]);
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void printArr(double[]x){
        for (int i = 0; i < x.length ; i++) {
            System.out.printf("%-10.2f", x[i]);
            System.out.println();
        }
    }
    //public static void printArray(double[][]x)

}

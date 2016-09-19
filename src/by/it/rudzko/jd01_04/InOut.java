package by.it.rudzko.jd01_04;

/**
 * Created by Kir on 07.09.2016.
 */
public class InOut {
    public static void printAr(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%6.2f", m[i][j]);
            }
            System.out.println();
        }
    }
    public static void printAr(double[] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.printf("%6.2f", m[i]);
        }
        System.out.println();
    }
    public static void printAr(double[] m, String name) {
        for (int i = 0; i < m.length; i++) {
            System.out.printf("\n"+name+"[%-1d]=%4.2f", i, m[i]);
        }
        System.out.println();
    }
}

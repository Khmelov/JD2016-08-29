package by.it.sukora.JD1_04;

/**
 * Created by stasi on 05.09.2016.
 */
public class InOut {
    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf("%6.2f", m[i][j]);
            System.out.println();
        }
        System.out.println();
    }
    public static void arrayPrint(double[] m) {
        for (int i = 0; i <m.length ; i++) {

                System.out.printf("%6.2f", m[i]);

        }
        System.out.println();
    }

}

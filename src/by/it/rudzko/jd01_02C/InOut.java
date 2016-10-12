package by.it.rudzko.jd01_02C;


public class InOut {
    static void printAr(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.printf("%8d", ar[i][j]);
            }
            System.out.println();
        }
    }

    static void printAr(double[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.printf("%8.2f", ar[i][j]);
            }
            System.out.println();
        }
    }

}

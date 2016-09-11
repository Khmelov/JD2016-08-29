package by.it.ilyukhin.jd01_4;


public class InOut {
    static void printArr(double[][] m){
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[0].length ; j++) {
                System.out.printf("%6.2f",m[i][j]);

            }
            System.out.println();

        }
        System.out.println();
    }
    static void printArr(double[] m){
        for (int i = 0; i < m.length ; i++) {
              System.out.printf("%6.2f",m[i]);
        }
        System.out.println();
    }
}

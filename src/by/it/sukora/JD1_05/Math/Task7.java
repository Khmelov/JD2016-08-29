package by.it.sukora.JD1_05.Math;

import java.util.Arrays;

import static java.lang.Math.random;
import static java.lang.Math.round;

/**
 * Created by stasi on 12.09.2016.
 */
public class Task7 {
    public static double[][] function() {
        double[][] res = new double[2][];
        double[] T = new double[34];
        double[] temp = new double[34];
        int length = 0;
        for (int i = 0; i < T.length; i++) {
            T[i] = (double) round((random() * 5 + 4) * 100) / 100;//округление до 0.01
            if (T[i] < 0.4 * i) {
                temp[length] = T[i];
                length++;
            }

        }
        double[] K = new double[length];
        System.arraycopy(temp, 0, K, 0, length);
        Arrays.sort(K);
        res[0] = K;
        res[1] = T;
        return res;
    }
    static public int[] sizeOfTable(double[] mas) {
        int rows, cols;
        int[] rowsCols = new int[2];
        cols = 4;
        while (cols > 1) {
            if ((double) mas.length / cols - (int) ((double) mas.length / cols) == 0) {
                break;
            }
            cols--;
        }
        rows = mas.length / cols;
        rowsCols[0] = rows;
        rowsCols[1] = cols;
        return rowsCols;
    }
    static public void printMatrixCols(int cols, String name, double[] mas, boolean flag) {
        int col = 0;
        int rows = mas.length / cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flag) {
                    System.out.print(name);
                    System.out.printf("[% -3d]=%-9.4f ", i + j * rows + 1, mas[i + j * rows]);
                    col++;
                    if ((0 == col % cols) || (mas.length - 1 == i)) {
                        System.out.println();
                    }
                } else {
                    System.out.print(name);
                    System.out.printf("[% -3d]=%-9.4f ", j + i * cols + 1, mas[j + i * cols]);
                    col++;
                    if ((0 == col % cols) || (mas.length - 1 == i)) {
                        System.out.println();
                    }
                }
            }
        }

    }
}

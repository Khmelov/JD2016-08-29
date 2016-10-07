package by.it.tsiamruk.jd01_15;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by waldemar on 04/10/2016.
 */
public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = (int) (Math.floor(Math.random() * 30) - 15);
            }
        }

        //to console
        for (int[] aMatrix1 : matrix) {
            for (int j = 0; j < aMatrix1.length; j++) {
                System.out.printf("%3d ", aMatrix1[j]);
                if (j == aMatrix1.length - 1) {
                    System.out.println();
                }
            }
        }

        //to File
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/tsiamruk/");
        String file = path + "jd01_15/matrix.txt";

        try (PrintWriter print = new PrintWriter(file)) {
            for (int[] aMatrix : matrix) {
                for (int j = 0; j < aMatrix.length; j++) {
                    print.printf("%3d ", aMatrix[j]);
                    if (j == aMatrix.length - 1) {
                        print.println();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

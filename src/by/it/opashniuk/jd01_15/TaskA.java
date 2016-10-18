package by.it.opashniuk.jd01_15;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix=new int[4][4];
        int length=matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = (int) (Math.random() * 30 - 15);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }

        String src=System.getProperty("user.dir");
        src=src+"/src/by/it/opashniuk/";
        String file=src+"jd01_15/Matrix.txt";

        try (PrintWriter print = new PrintWriter(file)) {
            for (int[] aMatrix : matrix) {
                for (int i = 0; i < aMatrix.length; i++) {
                    print.printf("%3d ", aMatrix[i]);
                    if (i == aMatrix.length - 1) {
                        print.println();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

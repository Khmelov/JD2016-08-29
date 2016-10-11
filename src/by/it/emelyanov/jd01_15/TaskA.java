package by.it.emelyanov.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {

        String src = System.getProperty("user.dir") + "/src/by/it/emelyanov/jd01_15/";
        String filename = src + "matrix.txt";
        File file = new File(filename);

        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (int) (Math.random() * 31 - 15);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");


        try (PrintStream printStream = new PrintStream(file)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    printStream.printf("%3d ", value);
                }
                printStream.println();
            }
            printStream.println();
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка" + e);
        }
    }
}

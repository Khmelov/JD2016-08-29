package by.it.artiuschik.jd_01_15;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            //TaskA
            int[][] matrix = TaskA.createMatrix();
            TaskA.printToConsole(matrix);
            TaskA.printToFile(matrix, "matrix.txt");
            //TaskB
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

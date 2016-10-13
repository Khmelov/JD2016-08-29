package by.it.artiuschik.jd_01_15;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            //TaskA
            int[][] matrix = by.it.artiuschik.jd_01_15.TaskA.createMatrix();
            by.it.artiuschik.jd_01_15.TaskA.printToConsole(matrix);
            by.it.artiuschik.jd_01_15.TaskA.printToFile(matrix, "matrix.txt");
            //TaskB
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

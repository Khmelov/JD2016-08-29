package by.it.ilyukhin.jd01_15;

import java.io.IOException;


public class Runner {
    public static void main(String[] args) {
            try {
                int[][] matrix = TaskA.createMatrix();
                TaskA.printToConsole(matrix);
                TaskA.printToFile(matrix, "matrix.txt");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO error");
            }
        }
    }


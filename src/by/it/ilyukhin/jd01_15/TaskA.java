package by.it.ilyukhin.jd01_15;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    static  int[][] createMatrix()
    {
        int[][] matrix=new int[4][4];
        for (int[] row:matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                row[j]=((int)(Math.random()*31)-15);
            }
        }
        return matrix;
    }
    static void printToFile(int[][] matrix,String fileName) throws IOException
    {
        String filePath = System.getProperty("user.dir") + "/src/by/it/ilyukhin/jd01_15/" + fileName;
        PrintWriter out = new PrintWriter(new FileWriter(filePath));
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                out.format("%3d ",row[j]);
            }
            out.println();
        }
        out.close();
    }
    static void printToConsole(int[][] matrix) {
        for (int[] row:matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d ",row[j]);
            }
            System.out.println();
        }
    }
}

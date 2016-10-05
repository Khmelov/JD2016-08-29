package by.it.senchenko.jd01_15;


import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("D:\\JD2016-08-29\\src\\by\\it\\senchenko\\jd01_15\\matrix.txt")) {
            PrintStream printStream = new PrintStream(fileOutputStream);
            int size = 4;
            int matrix[][] = new int[size][size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = random.nextInt(31) - 15;
                }
            }


            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    printStream.printf(" %3d ",matrix[i][j]);
                    System.out.printf(" %3d ",matrix[i][j]);
                }
                printStream.printf("\n");
                System.out.println("\n");
            }
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

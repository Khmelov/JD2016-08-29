package by.it.laurynovich.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Random;

/**
 * Created by nadabratb on 10/12/2016.
 */
public class TaskA {
    private int n;
    private int a;
    private int b;
    private int[][] matrix;

    //конструктор
    public TaskA(int n, int a, int b){
        this.n = n;
        this.a = a;
        this.b = b;
        this.matrix = new int[n][n];
    }

    public void matrixFile(){

        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               this.matrix[i][j] = this.a + rnd.nextInt(this.b - this.a) ;
            }
        }
    }

    public void printMatrix(){
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3.0f ", (double)matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void printMatrix(String filename) {
        Formatter formatter = null;
        try (PrintWriter printer = new PrintWriter(new FileWriter(filename, false))) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    formatter = new Formatter();
                    String s = formatter.format("%3.0f ", (double) this.matrix[i][j]).toString();
                    printer.append(s);
                }
                printer.println("\n");
            }
            printer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (formatter != null) formatter.close();
    }
}

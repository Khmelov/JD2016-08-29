package by.it.artiuschik.jd_01_05;

import java.util.Scanner;

public class Util {
    static public String readFromConsole() {
        return new Scanner(System.in).nextLine();
    }

    static public void printArray(double[] array, String name, int cols) {
        int col = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f ", i, array[i]);
            col++;
            if ((col % cols == 0) || (i == array.length - 1)) {
                System.out.println();
            }
        }
    }

    static public void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-9.4f ", array[i]);
        }
        System.out.println();
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

    static public void printMatrixCols(int cols, String name, double[] mas, boolean flag)
            /*если  flag==false индекс изменяется по строкам, если  true-по столбцам*/ {
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
package by.it.rudzko.jd01_02C;

import java.util.ArrayList;

public class Helper {

    static void task1(int[][] ar) {
        int add = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length - 2; j++) {
                if (ar[i][j] > 0) {
                    for (int y = j + 1; y < ar.length; y++) {
                        if (ar[i][y] > 0) break;
                        add += ar[i][y];
                    }
                    break;
                }
            }
            System.out.println(IMessages.SUM + (i + 1) + ": " + add);
            add = 0;
        }
    }

    static int[][] task2(int[][] ar) {
        int[][] transMatrix = new int[ar.length][ar.length];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                transMatrix[i][j] = ar[j][i];
            }
        }
        return transMatrix;
    }

    static int[][] task3(int[][] ar) {
        int[][] matrix = new int[ar.length][ar.length];

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                matrix[i][j] = ar[i][ar.length - 1 - j];
            }
        }
        return matrix;
    }

    static double[][] task4(int[][] ar) {
        double[][] matrix = new double[ar.length][ar.length];
        ArrayList<Double> means = new ArrayList<>();
        double sum = 0.0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                sum += (double) (ar[i][j]);
                if (j == ar.length - 1) {
                    means.add(sum / ar.length);
                    sum = 0.0;
                }
            }
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                matrix[i][j] = (double) (ar[i][j]) - means.get(i);
            }
        }
        return matrix;
    }

    static int[][] task5(int[][] ar) {
        int max = 0;
        int str = 0;
        int col = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i][j] > max) {
                    max = ar[i][j];
                    str = i;
                    col = j;
                }
            }
        }
        int a;
        int b;

        int[][] matrix = new int[ar.length - 1][ar.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                a = (i < str) ? i : i + 1;
                b = (j < col) ? j : j + 1;
                matrix[i][j] = ar[a][b];
            }
        }
        return matrix;
    }

    static int[][] task6(int[][] ar) {
        int min = Integer.MAX_VALUE;
        int str = 0;
        int col = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i][j] < min) {
                    min = ar[i][j];
                    str = i;
                    col = j;
                }
            }
        }
        int[][] matrix = new int[ar.length][ar.length];
        int a;
        int b;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                a = (i < str) ? i + 1 : (i > str) ? i : 0;
                b = (j < col) ? j + 1 : (j > col) ? j : 0;
                matrix[i][j] = ar[a][b];
            }
        }
        return matrix;
    }

    static int[][] task7(int[][] ar) {

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i][j] == 0) {
                    for (int a = j + 1; a < ar.length; a++) {
                        if (ar[i][a] != 0) {
                            ar[i][j] = ar[i][a];
                            ar[i][a] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return ar;
    }
}


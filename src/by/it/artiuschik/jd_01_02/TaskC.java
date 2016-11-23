package by.it.artiuschik.jd_01_02;

import java.util.Random;

class TaskC {
    static int[][] createMatrix(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -random.nextInt(2 * n + 1) + n;
            }
        }
        return matrix;
    }

    static void printMatrix(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= 0) {
                    System.out.print(" " + matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void printMatrix(int n, double[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= 0) {
                    System.out.printf("% 4.2f ", matrix[i][j]);
                } else {
                    System.out.printf("%4.2f ", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    static int sumOfElements(int[][] matrix, int n) {
        int sum = 0;
        int strSum = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    flag = !flag;
                    continue;
                }
                strSum = (flag) ? (strSum + matrix[i][j]) : strSum;
            }

            if (flag) {
                strSum = 0;
                flag = false;
            } else {
                sum += strSum;
                strSum = 0;
            }
        }
        return sum;
    }

    static int[][] transponMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != j) && (j >= i)) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return matrix;
    }

    static int[][] rotate90(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            matrix[i] = by.it.artiuschik.jd_01_02.Util.reverseMas(matrix[i]);
        }
        matrix = TaskC.transponMatrix(matrix, n);
        return matrix;
    }

    static int[][] moveMinElement(int[][] matrix, int n) {
        int[] min = by.it.artiuschik.jd_01_02.Util.matrixMinMaxElement(matrix, n, true);
        int oldX = min[0];
        int oldY = min[1];
        int[] tempStr;
        int temp;
        tempStr = matrix[oldX];
        matrix[oldX] = matrix[1];
        matrix[1] = tempStr;
        for (int i = 0; i < n; i++) {
            temp = matrix[i][1];
            matrix[i][1] = matrix[i][oldY];
            matrix[i][oldY] = temp;

        }
        return matrix;
    }

    static int[][] deleteRowsAndCols(int[][] matrix) {
        int r[][] = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, r[i], 0, matrix[0].length);
        }
        int max[] = by.it.artiuschik.jd_01_02.Util.matrixMinMaxElement(matrix, matrix.length, false);
        int maxElem = max[2];
        int iMax;
        int jMax;
        int it, jt;
        while (maxElem == by.it.artiuschik.jd_01_02.Util.matrixMinMaxElement(r, r.length, false)[2]) {
            int rows = r.length;
            int cols = r[0].length;
            iMax = by.it.artiuschik.jd_01_02.Util.matrixMinMaxElement(r, r.length, false)[0];
            jMax = by.it.artiuschik.jd_01_02.Util.matrixMinMaxElement(r, r.length, false)[1];
            int[][] newMatrix = new int[rows - 1][cols - 1];
            it = 0;
            jt = 0;
            for (int i = 0; i < r.length; i++) {
                for (int j = 0; j < r[0].length; j++) {
                    if ((i != iMax) && (j != jMax)) {
                        newMatrix[it][jt] = r[i][j];
                        jt++;
                        if (jt == newMatrix[0].length) {
                            it++;
                        }
                    }
                }
                jt = 0;
            }
            r = newMatrix;
        }
        return r;
    }

    static int[][] moveZero(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            matrix[i] = by.it.artiuschik.jd_01_02.Util.moveZerosToEnd(matrix[i]);
        }
        return matrix;
    }

    static double[][] changeMatrix(int[][] matrix) {
        double[][] res = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[i][j] = matrix[i][j] - by.it.artiuschik.jd_01_02.Util.srednArifm(matrix[i]);
            }
        }
        return res;
    }

}

package by.it.grishechkin.jd01_04;

/**
 * Created by Yury on 18.09.2016.
 */
public class Util {
    public static double[] findRoot(double[][] a, double[] b) {
        int n = a.length;
        for (int row = 0; row < n; row++) {
            int best = row;
            for (int i = row + 1; i < n; i++)
                if (Math.abs(a[best][row]) < Math.abs(a[i][row]))
                    best = i;
            double[] tt = a[row];
            a[row] = a[best];
            a[best] = tt;
            double t = b[row];
            b[row] = b[best];
            b[best] = t;
            for (int i = row + 1; i < n; i++)
                a[row][i] /= a[row][row];
            b[row] /= a[row][row];
            // a[row][row] = 1;
            for (int i = 0; i < n; i++) {
                double x = a[i][row];
                if (i != row && x != 0) {
                    // row + 1 instead of row is an optimization
                    for (int j = row + 1; j < n; j++)
                        a[i][j] -= a[row][j] * x;
                    b[i] -= b[row] * x;
                }
            }
        }
        return b;
    }

    public static void multipleMV(double [][] matrix, double[] vector){
        double [] rez = new double[vector.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                rez[i] += matrix[i][j]*vector[j];
            }
        }
        for (double elem : rez) {
            System.out.println(elem);
        }
    }

    public static void multiple(double [][] mA, double[][] mB){
        int m = mA.length;
        int n = mB[0].length;
        int o = mB.length;
        double[][] res = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.format("%6f ", res[i][j]);
            }
            System.out.println();
        }
    }

    public static double[][] inverseMatrix(double A[][]) {
        int n = A.length;
        int row[] = new int[n];
        int col[] = new int[n];
        double temp[] = new double[n];
        int hold, I_pivot, J_pivot;
        double pivot, abs_pivot;

        if (A[0].length != n) {
            System.out.println("Error in Matrix.invert, inconsistent array sizes.");
        }
        // установиим row и column как вектор изменений.
        for (int k = 0; k < n; k++) {
            row[k] = k;
            col[k] = k;
        }
        // начало главного цикла
        for (int k = 0; k < n; k++) {
            // найдем наибольший элемент для основы
            pivot = A[row[k]][col[k]];
            I_pivot = k;
            J_pivot = k;
            for (int i = k; i < n; i++) {
                for (int j = k; j < n; j++) {
                    abs_pivot = Math.abs(pivot);
                    if (Math.abs(A[row[i]][col[j]]) > abs_pivot) {
                        I_pivot = i;
                        J_pivot = j;
                        pivot = A[row[i]][col[j]];
                    }
                }
            }
            if (Math.abs(pivot) < 1.0E-10) {
                System.out.println("Matrix is singular !");
            }
            //перестановка к-ой строки и к-ого столбца с стобцом и строкой, содержащий основной элемент(pivot основу)
            hold = row[k];
            row[k] = row[I_pivot];
            row[I_pivot] = hold;
            hold = col[k];
            col[k] = col[J_pivot];
            col[J_pivot] = hold;
            // k-ую строку с учетом перестановок делим на основной элемент
            A[row[k]][col[k]] = 1.0 / pivot;
            for (int j = 0; j < n; j++) {
                if (j != k) {
                    A[row[k]][col[j]] = A[row[k]][col[j]] * A[row[k]][col[k]];
                }
            }
            // внутренний цикл
            for (int i = 0; i < n; i++) {
                if (k != i) {
                    for (int j = 0; j < n; j++) {
                        if (k != j) {
                            A[row[i]][col[j]] = A[row[i]][col[j]] - A[row[i]][col[k]] *
                                    A[row[k]][col[j]];
                        }
                    }
                    A[row[i]][col[k]] = -A[row[i]][col[k]] * A[row[k]][col[k]];
                }
            }
        }
        // конец главного цикла

        // переставляем назад rows
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                temp[col[i]] = A[row[i]][j];
            }
            for (int i = 0; i < n; i++) {
                A[i][j] = temp[i];
            }
        }
        // переставляем назад columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[row[j]] = A[i][col[j]];
            }
            for (int j = 0; j < n; j++) {
                A[i][j] = temp[j];
            }
        }
        return A;
    }

    public static final double findDeterminant(final double A[][]) {
        int n = A.length;
        double D = 1.0;                 // определитель
        double B[][] = new double[n][n];  // рабочая матрица
        int row[] = new int[n];
        int hold, I_pivot;
        double pivot;
        double abs_pivot;

        if (A[0].length != n) {
            System.out.println("Error in Matrix.determinant, inconsistent array sizes.");
        }
        // создаем рабочую матрицу
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = A[i][j];
        // заполняем вектор перестановок
        for (int k = 0; k < n; k++) {
            row[k] = k;
        }
        // начало основного цикла
        for (int k = 0; k < n - 1; k++) {
            // находим наиболший элемент для основы
            pivot = B[row[k]][k];
            abs_pivot = Math.abs(pivot);
            I_pivot = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(B[row[i]][k]) > abs_pivot) {
                    I_pivot = i;
                    pivot = B[row[i]][k];
                    abs_pivot = Math.abs(pivot);
                }
            }
            // если нашлась такая основа, то меняем знак определителя и меняем местами столбцы
            if (I_pivot != k) {
                hold = row[k];
                row[k] = row[I_pivot];
                row[I_pivot] = hold;
                D = -D;
            }
            // проверка на ноль
            if (abs_pivot < 1.0E-10) {
                return 0.0;
            } else {
                D = D * pivot;
                // делим на основу
                for (int j = k + 1; j < n; j++) {
                    B[row[k]][j] = B[row[k]][j] / B[row[k]][k];
                }
                //  внутренний цикл
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                            B[row[i]][j] = B[row[i]][j] - B[row[i]][k] * B[row[k]][j];
                        }
                    }
                }
            }
            // конец внутреннего цикла
        }
        // конец главного цикла
        return D * B[row[n - 1]][n - 1];
    }
}

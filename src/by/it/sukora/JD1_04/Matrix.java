package by.it.sukora.JD1_04;

/**
 * Created by stasi on 08.09.2016.
 */
public class Matrix {


    public static final void invert(double A[][]) {
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
                return;
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
    }

    public static final double determinant(final double A[][]) {
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


    public static final double[][] multiply(final double A[][], final double B[][]
    ) {
        int ni = A.length;
        int nk = A[0].length;
        int nj = B[0].length;
        double C[][] = new double[ni][nj];
        if (B.length != nk || C.length != ni || C[0].length != nj) {
            System.out.println("Error in Matrix.multiply, incompatible sizes");
        }

        for (int i = 0; i < ni; i++)
            for (int j = 0; j < nj; j++) {
                C[i][j] = 0.0;
                for (int k = 0; k < nk; k++)
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
            }
        return C;
    }

    public static final void add(final double A[][], final double B[][],
                                 double C[][]) {
        int ni = A.length;
        int nj = A[0].length;
        if (B.length != ni || C.length != ni || B[0].length != nj || C[0].length != nj) {
            System.out.println("Error in Matrix.add, incompatible sizes");
        }
        for (int i = 0; i < ni; i++)
            for (int j = 0; j < nj; j++)
                C[i][j] = A[i][j] + B[i][j];
    }

    public static final void subtract(final double A[][], final double B[][], double C[][]) {
        int ni = A.length;
        int nj = A[0].length;
        if (B.length != ni || C.length != ni || B[0].length != nj || C[0].length != nj) {
            System.out.println("Error in Matrix.subtract, incompatible sizes");
        }
        for (int i = 0; i < ni; i++)
            for (int j = 0; j < nj; j++)
                C[i][j] = A[i][j] - B[i][j];
    }

    public static final boolean equals(final double A[][], final double B[][]) {
        int ni = A.length;
        int nj = A[0].length;
        boolean same = true;
        if (B.length != ni || B[0].length != nj) {
            System.out.println("Error in Matrix.equals," +
                    " incompatible sizes.");
        }
        for (int i = 0; i < ni; i++)
            for (int j = 0; j < nj; j++)
                same = same && (A[i][j] == B[i][j]);
        return same;
    }

    public static final void print(double A[][]) {
        int N = A.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                System.out.println("A[" + i + "][" + j + "]=" + A[i][j]);
    }

    public static final void multiply(double A[][], double B[], double C[]) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            C[i] = 0.0;
            for (int j = 0; j < n; j++) {
                C[i] = C[i] + A[i][j] * B[j];
            }
        }
    }

    public static void main(String[] args) {
        double[][] A = new double[][]{{1, 2}, {3, 1}};
        double[][] B = new double[][]{{1, 2}, {3, 1}};
        Matrix.invert(B);
        Matrix.print(Matrix.multiply(A, B));
    }
}
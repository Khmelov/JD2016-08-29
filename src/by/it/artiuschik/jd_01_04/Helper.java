package by.it.artiuschik.jd_01_04;

public class Helper {
    static double[] findRoot(double[][] a, double[] y) {
        double[] x = new double[y.length];
        //Подготовим операционную матрицу
        int n = a.length;
        double m[][] = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];

        }

        //Прямой ход(Гаусса)
        for (int diag = 0; diag < n - 1; diag++) {

            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = diag; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }

            }
        }

        //Обратный ход(Жордана)
        for (int diag = n - 1; diag > 0; diag--) {

            for (int row = diag - 1; row >= 0; row--) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;

                }

            }
            //Решение системы
            for (int i = 0; i < n; i++) {
                double div = m[i][i];
                for (int j = 0; j < n + 1; j++) {
                    m[i][j] = m[i][j] / div;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }
        return x;
    }

    static double det(double[][] mA) {
        int n = mA.length;
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                m[i][j] = mA[i][j];
            }
        }
        //прямой ход
        for (int diag = 0; diag < n - 1; diag++) {

            for (int row = diag + 1; row < n; row++) {
                double k = m[1][diag] / m[diag][diag];
                for (int col = diag; col < n; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;

                }
            }
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * m[i][i];
        }

        return res;
    }

    static double[] arrayMulVector(double a[][], double x[]) {
        double y[] = new double[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++)
                y[i] = y[i] + a[i][j] * x[j];
        }
        return y;
    }

    //умножение матрицы на матрицу
    public static double[][] arrayMulVector(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

    static double[][] inverseMatrix(double mA[][]) {
        int n = mA.length;
        double[][] m = new double[n][2 * n];
        //перенос матрицы mA в операционную матрицу
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                m[row][col] = mA[row][col];
            }
            m[row][n + row] = 1;
        }
        double k;
        //прямой ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < 2 * n; col++) {
                    m[row][col] = m[row][col] - k * m[diag][col];
                }

            }
        }
        //обратный ход
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < 2 * n; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }
        //привести главную диагональ
        for (int i = 0; i < n; i++) {
            k = 1 / m[i][i];
            for (int j = 0; j < 2 * n; j++) {
                m[i][j] = m[i][j] * k;
            }
        }
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = m[i][j + n];
            }
        }
        return res;
    }
}

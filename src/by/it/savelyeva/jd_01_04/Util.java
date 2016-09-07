package by.it.savelyeva.jd_01_04;

/**
 * Created by nato on 9/2/16.
 */
public class Util {

    public static double maxDoubleArray(double[] mas) {
        /**
         * @param mas is a linear array of double
         * @return maximal element of the given array
         */
        if (0 == mas.length) {
            return Double.MAX_VALUE;
        } else {
            double max = mas[0];
            for (double m: mas) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    public static double minDoubleArray(double[] mas) {
        /**
         * @param mas is a linear array of double
         * @return minimal element of the given array
         */
        if (0 == mas.length) {
            return Double.MIN_VALUE;
        } else {
            double min = mas[0];
            for (double m: mas) {
                if (min > m) min = m;
            }
            return min;
        }
    }
    public static double[] sortBubble(double[] mas) {
        /**
         * @param mas is a linear array of double
         * @see bubble sort algorithm
         * @return sorted linear array
        */
        int last = mas.length - 1;
        boolean sorted;
        do {
            sorted = true;
            for (int i=0; i<mas.length-1; i++) {
                if (mas[i] > mas[i+1]) {
                    double tmp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = tmp;
                    sorted = false;
                }
            }
            last--;
        } while (last>0);
        return mas;
    }
    public static double[] uniSort(double[] mas, boolean upDirection) {
        /**
         * @param mas is a linear array of double
         * @param upDirection is a boolean for sorting direction (ascending if true, otherwise descending)
         * @return sorted linear array
         */
        for (int i=0; i<mas.length-1; i++) {
            for (int j=i+1; j<mas.length; j++) {
                if (upDirection && mas[i]>mas[j] ||
                    !upDirection && mas[i]<mas[j]) {
                        double tmp = mas[i];
                        mas[i] = mas[j];
                        mas[j] = tmp;
                }
            }
        }
        return mas;
    }
    public static double[] arrayMulVector(double[][] x, double[] y) {
        /**
         * @param x is a 2-dimensional matrix of double
         * @param y is a linear array of double
         * @return a linear array
         */
        double[] z = new double[x.length];
        for (int i=0; i<x.length; i++) {
            for (int j=0; j<y.length; j++) {
                z[i] = z[i] + x[i][j] * y[j];
            }
        }
        return z;
    }

    public static double[][] arrayMulVector(double[][] x, double[][] y) {
        /**
         * @param x is a 2-dimensional matrix of double
         * @param y is a 2-dimensional matrix of double
         * @return a matrix
         */
        double[][] z = new double[x.length][y[0].length];
        for (int i=0; i<x.length; i++) {
            for (int j=0; j<y[0].length; j++) {
                for (int k=0; k<y.length; k++)
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
            }
        }
        return z;
    }

    public static double findDeterminant(double mas[][]) {
        /**
         * @param square matrix of double
         * @return determinant of the given matrix of double type
         *
         */
        double det = 0;
        int sign = 1;
        int p = 0, q = 0;
        int n = mas.length;
        if (n==1) det = mas[0][0];
        else{
            double b[][] = new double[n-1][n-1];
            for (int x=0 ; x < n ; x++) {
                p = 0;
                q = 0;
                for (int i=1; i < n; i++) {
                    for (int j=0; j < n; j++) {
                        if (j != x) {
                            b[p][q++] = mas[i][j];
                            if (q % (n-1) == 0) {
                                p++;
                                q = 0;
                            }
                        }
                    }
                }
                det += mas[0][x] * findDeterminant(b) * sign;
                sign = -sign;
            }
        }
        return det;
    }

    public static double[][] transposeMatrix(double[][] mas) {
        /**
         * @param matrix of double
         * @return transposed matrix
         *
         */
        for (int i=0; i<mas.length; i++) {
            for (int j=i; j<mas[0].length; j++) {
                double tmp = mas[i][j];
                mas[i][j] = mas[j][i];
                mas[j][i] = tmp;
            }
        }
        return mas;
    }

    private static double[][] findCoFactor(double[][] m) {
        /**
         * @param matrix of double
         * @return a cofactor matrix
         *
         */        double det;
        int n = m.length;
        double[][] b = new double[n][n];
        double[][] c = new double[n-1][n-1];
        for (int j=0; j<n; j++) {
            for (int i=0; i<n; i++) {
                int i1 = 0;
                for (int ii=0; ii<n; ii++) {
                    if (ii == i)
                        continue;
                    int j1 = 0;
                    for (int jj=0; jj<n; jj++) {
                        if (jj == j)
                           continue;
                        c[i1][j1] = m[ii][jj];
                        j1++;
                    }
                    i1++;
                }
                det = Util.findDeterminant(c);
                b[i][j] = Math.pow(-1.0, i+j+2.0) * det;
            }
        }
        return b;
    }

    public static double[][] inverseMatrix(double[][] m) {
        /**
         * @param matrix of double
         * @return inversed matrix
         *
         */
        double[][] invertedMatrix = new double[m.length][m.length];
        double det = findDeterminant(m);
        double[][] coFactorMatrix = findCoFactor(m);
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m.length; j++) {
                invertedMatrix[i][j] = coFactorMatrix[j][i] / det;
            }
        }
        return invertedMatrix;
    }

    public static double[] findRootGaussian(double[][] a, double[] y) {
        double[] x = new double[y.length];
        System.out.println("Extended matrix:");
        int n = a.length;
        double[][] m = new double[n][n * 2 + 1];
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        //InOut.arrayPrint2D(m);

        //System.out.println("Gauss (direct)");
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }
        //InOut.arrayPrint2D(m);

        //System.out.println("Jordan (reverse)");
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }
        //InOut.arrayPrint2D(m);

        //System.out.println("Solution matrix:");
        for (int i = 0; i < n; i++) {
            double div = m[i][i];
            for (int j = 0; j < n + 1; j++) {
                m[i][j] = m[i][j] / div;
                x[i] = m[i][j];
            }
        }
        //InOut.arrayPrint(x);
        return x;
    }

    public static boolean arraysEqual(double[] x, double[] y) {
        /**
         * @param x is a vector (linear array) of double
         * @param y is a vector (linear array) of double
         * @return true if both vectors are equal with precision=0.0000001 and false otherwise
         */
        double precision = 0.0000001;
        if (x.length != y.length) return false;
        for (int i=0; i<x.length; i++) {
            if ( Math.abs(x[i] - y[i]) > precision) return false;
        }
        return true;
    }

    public static boolean matrixIsE(double[][] x) {
        /**
         * @param x is a 2-dimensional matrix of double
         * @return true if x is equal to E (identity matrix) with precision=0.0000001 and false otherwise
         */
        double precision = 0.0000001;
        for (int i=0; i<x.length; i++) {
            for (int j=0; j<x[i].length; j++) {
                if (x.length != x[i].length) return false; //matrix is not square
                if (i != j) {
                    if ((float) Math.abs(x[i][j]) > precision ) return false;
                } else if ((float) Math.abs(x[i][j] - 1) > precision) return false;
            }
        }
        return true;
    }
}


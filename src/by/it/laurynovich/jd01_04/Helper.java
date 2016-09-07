package by.it.laurynovich.jd01_04;



/**
 * Created by vseotdala on 05.09.2016.
 */
public class Helper {
    public static double[] findRoot(double[][] a, double[] y, boolean showSteps) {
        // double x[]= new double[y.length];

        //подготовим операционную матрицу
        int n = a.length;
        double m[][] = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        System.out.println( "split matrix" );
        if (showSteps) InOut.printArr( m );

        // if (showSteps) InOut.printArr( m,"m" );
        //InOut.printArr(m);
        // прямой ход
        System.out.println( "-->>>" );
        for (int diag = 0; diag < n-1; diag++) {
            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < n+1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        if (showSteps) InOut.printArr( m );
        // обратный ход

        for (int diag = n - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < n + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        System.out.println( "<<--" );
        if (showSteps) InOut.printArr( m );

        //приводим главную давгональ к 1

        for (int i = 0; i < n; i++) {
            double res = 1 / m[i][i];
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = m[i][j] * res;
            }

        }
        System.out.println( "reduce matrix" );
        if (showSteps) InOut.printArr( m );

        double x[] = new double[m.length];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];

        }
        return x;
    }
        //public static double det(double[][] m);

    //проверка решения
    public static double[] mulArrVec(double a[][], double x[]){
            double y[]=new double[a.length];
                for (int i = 0; i <a.length ; i++) {
                    for (int j = 0; j <x.length ; j++) {
                        y[i]=y[i]+a[i][j]*x[j];
                    }
                }
                System.out.println();
            return y;
    }

    //Determinant
    public static double det(double a[][]) {
            double det = 1;
            for (int i = 0; i < a.length ; i++) {
                det = det * a[i][i];
            }
            System.out.println();
            return det;
        }

    public static double[][] findRoot2(double[][] a, double[] y, boolean showSteps) {
        // double x[]= new double[y.length];

        //подготовим операционную матрицу
        int n = a.length;
        double m[][] = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        // if (showSteps) InOut.printArr( m,"m" );
        //InOut.printArr(m);
        // прямой ход
        for (int diag = 0; diag < n-1; diag++) {
            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < n+1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        // обратный ход

        for (int diag = n - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < n + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        return m;
    }
    //
    public static double[][] getInverseMatrix(double[][] a, double[][] b, boolean showSteps) {

        //подготовим  матрицу
        int n = a.length;
        double m[][] = new double[n][2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n)
                    m[i][j] = a[i][j];
                else
                    m[i][j] = b[i][j-n];
            }

        }
        if (showSteps) InOut.printArr( m );

        // прямой ход

        for (int diag = 0; diag < n-1; diag++) {
            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        // обратный ход

        for (int diag = n - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        //приводим матрицу к 1 виду
        for (int i = 0; i < n; i++) {
            double res = 1 / m[i][i];
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = m[i][j] * res;
            }
        }
        InOut.printArr( m );
        //make M^-1
        double [][]m_1 = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n ; j++) {
                if(j > n-1) m_1[i][j-n] = m[i][j];
            }
        }
        return m_1;
    }

    public static double[][] mulArrArr(double a[][], double b[][]){
        double y[][] = new double[a.length][a.length];
        for (int i = 0; i <  a.length ; i++)
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length ; k++) {
                    y[i][j] = y[i][j] + a[i][k] * b[k][j];
                }
            }
        System.out.println();
        return y;
    }
}


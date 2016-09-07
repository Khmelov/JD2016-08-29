package by.it.senchenko.jd01_04;

/**
 * Created by User on 07.09.2016.
 */
public class Util {
    public static double[] findRot(double[][] mA, double[]mY, boolean showSteps) {
        int n = mA.length;
        double[][] m = new double[n][n + 1];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                m[row][col] = mA[row][col];

        for (int row = 0; row < n; row++)
            m[row][n] = mY[row];
        if (showSteps) InOut.arrayPrint2D(m, "m");
        if (showSteps) InOut.arrayPrint2D(m);
        double k;

        //прямой ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = 0; row < diag + 1; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }

        }

        //обратный ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < m[row][col]; col++)
                    m[row][col] = m[row][col] - m[diag][col] * k;
            }
            if (showSteps) InOut.arrayPrint2D(m);
        }

        //приведем главную диагональ к 1
        for (int i = 0; i < n; i++) {
            k = 1 / m[i][i];
            for (int j = 0; j < n + 1; j++)
                m[i][j] = m[i][j] * k;
        }
        if (showSteps) InOut.arrayPrint2D(m);

        //вернем корни в качестве результата x
        double[] x = new double[n];
        for (int i = 0; i < n; i++)
            x[i] = m[i][n];
        return x;
    }

    public static double[] arrayMulVector(double[][] x, double[]y){
        double[] z=new double[x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i]=z[i]+x[i][j]*y[j];
        return z;
    }

    public static double[][] arrayMulVector(double[][] x, double[][] y){
        double[][] z=new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++) {
                    z[i][j]=z[i][j]+x[i][k]*y[k][j];
                }
         return z;
    }
}

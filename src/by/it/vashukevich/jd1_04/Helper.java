package by.it.vashukevich.jd1_04;

/**
 * Created by Admin on 05.09.16.
 */
public class Helper {
    static double[] findroot(double[][] a, double[] y) {
        double x[] = new double[y.length];
        //подготовим операционную матрицу
        int n = a.length;
        double m[][] = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        InOut.printArr(m);
        //прямой ход (Гаусса)
        for(int diag=0;diag<n-1;diag++) {
            for (int row = diag+1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            InOut.printArr(m);
        }
        //обратный хд(Жордана)
        for(int diag=n-1;diag>0;diag--) {
            for (int row = diag-1; row >=0; row--) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            InOut.printArr(m);
        }
        //решение системы
        for(int i=0;i<n;i++){
            double div=m[i][i];
            for(int j=0;j<n+1;j++){
                m[i][j]=m[i][j]/div;
            }
        }
        //forint()
        InOut.printArr(m);
        return x;
    }
    //задание В
    /*static double det(double[][]m){
        int n=m.length;
        //прямой ход
        for(int diag=0;diag<n-1;diag++) {
            for (int row = diag+1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            InOut.printArr(m);
        }
        double res=1;
        for(int i=0;i<n;i++){
            res=res*m[i][i];
        }
        return res;
    }*/
    /*
    static doudle mulArrVec(double a[][],double x[]){
    double y[]=new double[a.lenght};
    for(int i=0;)
     */
}

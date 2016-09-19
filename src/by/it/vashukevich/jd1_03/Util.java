package by.it.vashukevich.jd1_03;

/*
 * Created by Admin on 04.09.16.
 */
public class Util {

    static double[] sortMas(double[]mas) {
        //double[] m = {6, 4, 8, 12, 9, 21, 14, 32};
       // PrintMas(m);
        boolean swap=true;
        int last = mas.length-1;
        do {
            swap = true;
            for (int j = 0; j < last; j++) {  //индекс j в массиве
                if (mas[j] < mas[j + 1]) {
                    double baf = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = baf;
                    swap = false;
                }
            }
            last--;
        }
        while (!swap) ;
        //PrintMas(m);
        return mas;
    }

   /* protected static void PrintMas(double[] massive) {
        for(double m:massive)
            System.out.print(m  + " ");
        System.out.println();
    }*/

    static double[] sortIntArray(double[]mas,boolean upDirection) {
        //mass = new double[]{2, 12, 3, 14, 15, 61, 20, 18};
        for(int i=0;i<mas.length-1;i++)
            for(int j=i+1;j<mas.length;j++)
                if((upDirection && mas[i]<mas[j])  || (upDirection && mas[i]<mas[j])) {
                    double m = mas[i];
                    mas[i] = mas[j];
                    mas[j] = m;
                }
                return mas;
    }
}
/*public class Util {
    static double[] bubbleSort(double[] mas){
        int last= mas.length-1;
        boolean sorted=true;

        do {
            sorted=true;
            for (int i = 0; i < mas.length-1 ; i++) {
                if(mas[i]>mas[i+1]){
                    double tmp=mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=tmp;
                    sorted=false;
                }
            }
            last--;
        }
        while (!sorted);
        return mas;
    }
    //min max sort
    static double[] uniSort(double[] mas, boolean upDirection){
        for (int i = 0; i < mas.length-1;  i++) {
            for (int j = i+1; j < mas.length;  j++) {
                if((!upDirection && mas[i]<mas[j])||(upDirection && mas[i]>mas[j])){
                    double tmp=mas[i];
                    mas[i]=mas[j];
                    mas[j]=tmp;
                }
            }
        }

        return mas;
    }
    //Array multipplication vector
    static double[] arrayMulVector(double[][]a, double[]b){
        double[] n = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++)
                n[i] = n[i] + a[i][j]*b[j];
        }
        return n;
    }
    //Array multiplication Array
    static double[][] arrayMultyMatrix(double[][]a, double[][]b){
        double[][] n=new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j <b[0].length; j++)
                for (int k = 0; k <b.length; k++)
                    n[i][j]=n[i][j]+a[i][k]*b[k][j];
        return n;
    }

}*/

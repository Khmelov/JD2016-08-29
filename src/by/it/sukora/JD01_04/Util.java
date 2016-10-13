package by.it.sukora.JD01_04;

public class Util {
   public static double [] getRes(double x[][],double y[]){
        double n[]=new double[y.length];

        double n2[][]=new double[x.length][x.length+1];
        for (int i=0; i<x.length; i++){
            for (int j=0; j<x.length; j++){
                n2[i][j]=x[i][j];
            }
            n2[i][x.length]=y[i];

        }
      for (int rowUp=0; rowUp<x.length-1; rowUp++) {
          for (int rowUnd = rowUp + 1; rowUnd < x.length; rowUnd++) {
              double k = n2[rowUnd][rowUp] / n2[rowUp][rowUp];
              for (int col = 0; col < x.length + 1; col++) {
                  n2[rowUnd][col] = n2[rowUnd][col] - n2[rowUp][col] * k;
              }
          }
      }


       for (int rowUnd =x.length-1; rowUnd>0; rowUnd--) {
           for (int rowUp = rowUnd - 1; rowUp >= 0; rowUp--) {
               double k = n2[rowUp][rowUnd] / n2[rowUnd][rowUnd];
               for (int col = 0; col < x.length + 1; col++) {
                   n2[rowUp][col] = n2[rowUp][col] - n2[rowUnd][col] * k;
               }
           }
       }

       for (int i=0; i<x.length; i++) {
           double div = n2[i][i];
           for (int j = 0; j < x.length + 1; j++) {
               n2[i][j] = n2[i][j] / div;
           }
       }

       double res[]=new double[x.length];
       for (int i=0; i<x.length; i++)
           res[i]=n2[i][x.length];

    return res;
   }

    public static double[] check(double a[][], double b[]){
        double y[]=new double[a.length];
        for (int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                y[i]=y[i]+a[i][j]*b[j];
            }
        }
        return y;
    }

    public static double findDet(double[][]x){
        double copy[][]=new double[x.length][x.length];
        for (int i=0; i<x.length; i++){
            for (int j=0; j<x.length; j++){
                copy[i][j]=x[i][j];
            }


        }
        for (int rowUp=0; rowUp<x.length-1; rowUp++) {
            for (int rowUnd = rowUp + 1; rowUnd < x.length; rowUnd++) {
                double k = copy[rowUnd][rowUp] / copy[rowUp][rowUp];
                for (int col = 0; col < x.length; col++) {
                    copy[rowUnd][col] = copy[rowUnd][col] - copy[rowUp][col] * k;
                }
            }
        }

        double det=1;
        for (int i=0; i<copy.length; i++){
                det=det*copy[i][i];
         }

        return det;
    }
    public static double[][] findM(double x[][]){
        double[][] e=new double[x.length][x.length];
        for (int i=0; i<x.length; i++){
            e[i][i]=1;
        }
        double om[][]=new double[x.length][x.length*2];
        for (int i=0; i<x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                om[i][j] = x[i][j];
            }
        }

        for (int i=0; i<x.length; i++){
            int a=0;
            for (int j=x.length; j<x.length*2; j++){
                om[i][j]=e[i][a];
                a++;
            }
        }

        for (int rowUp=0; rowUp<x.length-1; rowUp++) {
            for (int rowUnd = rowUp + 1; rowUnd < x.length; rowUnd++) {
                double k = om[rowUnd][rowUp] / om[rowUp][rowUp];
                for (int col = 0; col < x.length*2; col++) {
                    om[rowUnd][col] = om[rowUnd][col] - om[rowUp][col] * k;
                }
            }
        }


        for (int rowUnd =x.length-1; rowUnd>0; rowUnd--) {
            for (int rowUp = rowUnd - 1; rowUp >= 0; rowUp--) {
                double k = om[rowUp][rowUnd] / om[rowUnd][rowUnd];
                for (int col = 0; col < x.length*2; col++) {
                    om[rowUp][col] = om[rowUp][col] - om[rowUnd][col] * k;
                }
            }
        }
        for (int i=0; i<x.length; i++) {
            double div = om[i][i];
            for (int j = 0; j < x.length*2; j++) {
                om[i][j] = om[i][j] / div;
            }
        }
        double res[][]=new double[x.length][x.length];
        for (int i=0; i<x.length; i++){
            int a=x.length;
            for (int j=0; j<x.length; j++){
                res[i][j]=om[i][a];
                a++;
            }
        }

        return res;
    }

    public static double[][] checkM(double[][]x, double[][]y){
        double res[][]=new double[x.length][x.length];
        for (int i=0; i<x.length; i++){
            for (int j=0; j<x.length; j++){
                for(int k=0; k<x.length; k++){
                    res[i][j]=res[i][j]+x[i][k]*y[k][j];}
            }
        }
        return res;
    }
}

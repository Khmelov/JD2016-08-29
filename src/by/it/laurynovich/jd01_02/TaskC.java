//package by.it.laurynovich.jd01_02;
//
///**
// * Created by vseotdala on 08.09.2016.
// */
//public class TaskC {
//
//    public static double[][] makeMatrix(int n) {
//        double m[][] = new double[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                m[i][j] = (int) (Math.random() * (2 * n + 1) - n);
//            }
//        }
//        return m;
//    }
//
//    //        1. Найти сумму элементов матрицы, расположенных между первым и
////        вторым положительными элементами каждой строки.
//    public static double[] getSum(double[][] mas) {
//        double[] masSum = new double[mas.length];
//        double sum = 0;
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < mas.length; i++) {
//            masSum[i] = 0;
//            for (int j = 0; j < mas.length; j++) {
//                if (mas[i][j] > 0) {
//                    a = j;
//                    if (j > a) {
//                        b = j;
//                    }
//                }
//            }
//            for (int k = a + 1; k < b ; k++) {
//                    masSum[i] = masSum[i] + mas[i][k];
//            }
//
//        }
//        return masSum;
//    }
//}

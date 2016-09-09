package by.it.laurynovich.jd01_02;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by vseotdala on 08.09.2016.
 */
public class TaskB {
    // 1. Определить принадлежность некоторого значения k интервалу [n, m].
    public static boolean belongToInretval (int a, int b, int k){
        int n, m;
        boolean belong;
        if (a >= b ){
             n = a;
             m = b;}
        else{
            n = b;
            m = a;}

        if (k >= m && k <= n ) {
            belong = true;
        }
        else {
            belong = false;
        }
        return belong;
    }

    //2. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
    //(k выберите квадратом целого числа).
    public static void printMatrixForm (int k) {

        int longStr = 0;
        for (int i = 0; i < k; i++) {
            if (i * i == k){
                longStr = i;
                break;
            }
        }
        if (longStr == 0)
            System.out.println("Введенное число не явлется квадратом целого числа!");
        else {
            for (int i = 1; i < k + 1; i++) {
                if (i % longStr == 0)
                    System.out.println(i+" ");
                else {
                    if (i < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(i+" ");
                }
                if (k > 100) {
                    if(i < 100)
                    System.out.print(" ");
                }
            }
        }
    }

   // 3. Найти корни квадратного уравнения. Параметры уравнения передавать с
   // командной строкой.
    public static double[] findRoots (double [] mas){

        double sqDiskr = Math.sqrt(mas[1] * mas[1] - 4* mas[0] * mas[2]);
        double x1 = (-mas[1] + sqDiskr)/(2*mas[0]);
        double x2 = (-mas[1] - sqDiskr)/(2*mas[0]);
        double[] newMas = new double[2];
        newMas[0] = x1;
        newMas[1] = x2;

        return newMas;
    }

   //    4. Ввести число от 1 до 12. Вывести на консоль название месяца,
   //    соответствующего данному числу. Осуществить проверку корректности
   //    ввода чисел.
    public static void getMonth (int month){

        String monthString;
                    switch (month){
                case 1: monthString = "January";
                    break;
                case 2: monthString = "February";
                    break;
                case 3: monthString = "March";
                    break;
                case 4: monthString = "April";
                    break;
                case 5: monthString = "May";
                    break;
                case 6: monthString = "June";
                    break;
                case 7: monthString = "July";
                    break;
                case 8: monthString = "August";
                    break;
                case 9: monthString = "September";
                    break;
                case 10: monthString = "October";
                    break;
                case 11: monthString = "November";
                    break;
                case 12: monthString = "December";
                    break;
                default: monthString = "Месяц введен неправильно!";

        }
        System.out.println(monthString);

    }
}

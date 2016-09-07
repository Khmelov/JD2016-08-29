package by.it.tsiamruk.jd01_02;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.Scanner;

public class TaskB {
    //находится ли рандомное число k в интервале чисел.
    static int intervalGetting() {
        int a = 5;
        int b = 50;
        int k = (int) (Math.random() * 10);
        if (k >= a && k <= b) {
            System.out.println("Число " + k + " принадлежит интервалу");
        } else {
            System.out.println("Число " + k + " не принадлежит интервалу");
        }
        return 0;
    }

    //вывод массива в виде матрицы
    static int matrixOutput() {
        int k = (int) Math.pow(3, 2);
        int a = (int) Math.sqrt(k);
        // слева направо
        for (int i = 1; i <= k; i++) {
            System.out.print(i + " ");
            if (i%a==0) {
                System.out.println();
            }
        }
        System.out.println();
        //сверху вниз
        int[][] matrix=new int[a][a];
        for (int i = 0, k_=1; i < a ; i++) {
            for (int j = 0; j < a ; j++) {
                matrix[j][i]=k_++;
            }
        }
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        return 0;
    }

    static double  uravnenie(){
        //int a = Integer.parseInt(args[0]);
        //int b = Integer.parseInt(args[1]);
        //int c = Integer.parseInt(args[2]);
        int a = 17;
        int b = 27;
        int c = 1;

        System.out.format("%dx^2 + %dx + %d = 0\n", a, b, c);

        double D = b*b -4*a*c;
        if (D<0){
            System.out.println("Уравнение не имеет решения");
        }
        else if(D==0){
            double x = -b/(2*a);
            System.out.println("Корень = " + x);
        }
        else {
            double x1 = -b + Math.sqrt(D) / (2 * a);
            double x2 = -b - Math.sqrt(D) / (2 * a);
            System.out.format("Первый корень = %.4f \nВторой корень = %.4f\n", x1, x2);
        }
        return 0;
    }

    static String monthesOfYear(){
        String[] monthes = {"January","February","March","April","May","June","July","August",
                "September","October","November","December"};
        int n = 2;
        if (n>=1 && n<=12) {
            System.out.println(monthes[n - 1]);
        }else {
            System.out.println("Не месяц");
        }
        return null;
    }
}

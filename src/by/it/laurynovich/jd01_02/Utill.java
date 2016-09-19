package by.it.laurynovich.jd01_02;

import java.util.Scanner;

public class Utill {

    public static String readFromConsole() {
        String result;
        Scanner scanner = new Scanner( System.in );
        result = scanner.nextLine();
        return result;

        // return new Scanner(System.in).nextLine();
    }

    public static int[] getArrayInt(String line) {

        String strMas[] = line.split( " " );

        int mas[] = new int[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            mas[i] = Integer.parseInt( strMas[i] );
        }
        return mas;
    }

    public static void printArray(int[] mas) {
        for (int value : mas) {
            System.out.println( value );
        }
    }


    public static void printAverage ( int[] mas, int aver){
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < aver)
                System.out.println(mas[i]);
        }
    }

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
                        System.out.println(" " + i);
                    else {
                        if (i < 10) {
                            System.out.print(" ");
                        }
                        System.out.print(" " + i);
                    }

                }
            }
    }

    public static double[] getArrayDouble(String line) {

        String strMas[] = line.split( " " );

        double mas[] = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            mas[i] = Double.valueOf(strMas[i]);
        }
        return mas;
    }

    public static void printArrayD (double[] mas) {
        for (int i = 0; i < mas.length; i++) {

            System.out.println( mas[i] );
        }
    }


}
package by.it.laurynovich.jd_01_02;

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
}
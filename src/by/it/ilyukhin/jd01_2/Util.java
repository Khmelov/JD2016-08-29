package by.it.ilyukhin.jd01_2;

import java.util.Scanner;

public class Util {
    static String getConsoleLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        return line;
    }

    static int[] lineToIntArray(String line) {
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);

        }
        return array;
    }
   //TaskB1
    /*static int inputK() {
        Scanner inputK = new Scanner(System.in);
        int k = inputK.nextInt();
        return k;

    }

    static int inputN() {
        Scanner inputN = new Scanner(System.in);
        int n = inputN.nextInt();
        return n;

    }

    static int inputM() {
        Scanner inputM = new Scanner(System.in);
        int m = inputM.nextInt();
        return m;
    }

    static int inputN2() {
        Scanner inputN2 = new Scanner(System.in);
        int N = inputN2.nextInt();
        return N;

    }
    static double inputK2() {
        Scanner inputK2=new Scanner(System.in);
        double K= inputK2.nextDouble();
        return K;
    }*/
}


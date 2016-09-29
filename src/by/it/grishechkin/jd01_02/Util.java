package by.it.grishechkin.jd01_02;

import by.it.savelyeva.jd_01_workbook.Task;

import java.util.Scanner;

/**
 * Created by Yury on 31.08.2016.
 */
public class Util {

    static public String readFromConsole () {
        return new Scanner(System.in).nextLine();
    }

    static public int [] getArrayInt (String line) {
       //String line = "1 22 333 4444 55555";

        String strMas [] = line.split(" ");
        int [] intMas = new int[strMas.length];

        for(int i = 0; i < strMas.length; i++) {
            intMas[i] = Integer.parseInt(strMas[i]);
        }
        return intMas;
    }

    static public void printArray (int[] mas) {
        for (int value : mas) {
            System.out.println(value);
        }
    }

    static public void printNumbersLessMean(int[] mas) {
        double mean = TaskA.meanNumbers(mas);
        System.out.print("Numbers Les sMean: ");
        for (int value : mas) {
            if (TaskA.getLengthNumber(value) < mean) {
                System.out.print(value + "\t");
            }
        }
        System.out.println("");
    }

    static public void printUniqNumber (int[] mas) {
        for (int value : mas) {
            if (TaskA.isNumberOfDifferentDigits(value)) {
                System.out.println("The number is unique: " + value);
                break;
            }
        }
    }
}

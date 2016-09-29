package by.it.grishechkin.jd01_02;

import java.util.Scanner;

import static by.it.grishechkin.jd01_02.Util.*;

public class Runner {

    public static void main(String[] args) {

        int [] mas = getArrayInt(readFromConsole());
        printArray(mas);

        System.out.println("ShortNum = " + TaskA.getShortNumber(mas) + "\tLength: " + TaskA.getLengthNumber(TaskA.getShortNumber(mas)));
        System.out.println("LongNum = " + TaskA.getLongNumber(mas) + "\tLength: " + TaskA.getLengthNumber(TaskA.getLongNumber(mas)));
        Util.printNumbersLessMean(mas);
        Util.printUniqNumber(mas);
        System.out.println("\nTaskB:");
        System.out.println(TaskB.isOnInterval(5, 6, 100));
        System.out.println("\nMatrix:");
        TaskB.matrixPrint(4);
        TaskB.solve();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        TaskB.mounth(month);

    }
}

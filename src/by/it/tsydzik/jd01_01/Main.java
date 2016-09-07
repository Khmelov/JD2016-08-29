package by.it.tsydzik.jd01_01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        String line = Util.getOneLine();
        String line = "-456 -11 -15 22 23 341 123 123 345 42 444 12";

        int[] intArray = Util.lineToIntArray(line);
        String[] stringsArray = Util.lineToStringArray(line);

        System.out.println("Task A1");
        System.out.println(TaskA1.getShortNum(intArray));
        System.out.println(TaskA1.getLongNum(intArray));

        System.out.println("\n" + "Task A2");
        TaskA2.getAverage(intArray);

        System.out.println("\n" + "Task A3");
        TaskA3.isDifferentNumbers(intArray);

        System.out.println("\n" + "Task B1");
        int number = 10;
        int startInterval = 1;
        int endInterval = 100;

        if (TaskB1.isBelongs(number, startInterval, endInterval)) {
            System.out.printf("The number %d belongs to the interval [%d, %d]", number, startInterval, endInterval);
        }

        System.out.println("\n" + "Task B2");
        int endIntervalTaskB2 = 99;
        TaskB2.printMatrix(endIntervalTaskB2);

        System.out.println("\n" + "Task B3");

        System.out.println("\n" + "Task B4");
        TaskB4.getMonthName();
    }
}

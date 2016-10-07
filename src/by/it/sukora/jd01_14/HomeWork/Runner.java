package by.it.sukora.jd01_14.HomeWork;


import java.io.File;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Task A");
        TaskA myTaskA = new TaskA("randoms.bin");
        ArrayList<Integer> nums = myTaskA.generateArrayList(20);
        File f;
        f = myTaskA.writeArrayListToBinaryFile(nums);
        ArrayList<Integer> list = myTaskA.readNumsFromBinaryFileToArrayList(f);
        double avg = myTaskA.calculateAverage(list);
        System.out.printf("\nСреднее арефметическое = %.2f\n", avg);

        System.out.println();

        System.out.println("Task B");
        TaskB myTaskB = new TaskB("jd01_14/HomeWork/", "text.txt");
        myTaskB.printStatistics();
        System.out.println();

        System.out.println("Task C");
        TaskC myTaskC = new TaskC();
        myTaskC.printFilesDirsSeparately();
        System.out.println();
    }
}

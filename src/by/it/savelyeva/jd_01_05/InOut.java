package by.it.savelyeva.jd_01_05;

/**
 * Created by nato on 9/7/16.
 */
import java.util.Scanner;

public class InOut {

    public static String[] readFromConsole() {
        //String line = "-21 7 2 567 44 55 -3 88 999";
        System.out.print("Enter space-separated numbers: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArray = line.split(" ");
        return strArray;
    }

    public static void printArray(double[] mas, String name, int cols) {
        System.out.printf("Array %s:\n", name);
        int col = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-8.5f ", name, i, mas[i]);
            col++;
            if ((0 == col % cols) || (mas.length - 1 == i)) System.out.println();
        }
    }

}

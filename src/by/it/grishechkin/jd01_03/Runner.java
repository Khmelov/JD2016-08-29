package by.it.grishechkin.jd01_03;

/**
 * Created by Yury on 02.09.2016.
 */
public class Runner {

    public static void main(String[] args) {
        String line = InOut.consoleReadLine();
        System.out.println(line);
        double mas[] = InOut.arrayFromString(line);
        InOut.arrayPrint(mas, "m", 4);

        System.out.println("\nEnter matrix line count");
        int strCount = Integer.valueOf(InOut.consoleReadLine());
        String [] matrix = new String[strCount];
        System.out.println("\nEnter matrix lines");
        for (int i = 0; i < strCount; i++) {
            matrix[i] = InOut.consoleReadLine();
        }
        for (int i = 0; i < strCount; i++) {
            System.out.println(matrix[i]);
        }
    }
}

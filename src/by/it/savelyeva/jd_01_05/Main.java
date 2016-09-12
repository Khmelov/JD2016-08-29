package by.it.savelyeva.jd_01_05;

import by.it.savelyeva.jd_01_05.math.*;

public class Main {
    /**
     * variant 10
     */

    public static void main(String[] args) {
        System.out.println("Task 1:");
        Task1 myTask1 = new Task1();
        System.out.printf("y = %10.6f (calculated using parts)\n", myTask1.partsCalculateY(1.26453));
        System.out.printf("y = %10.6f (calculated as expression)\n", myTask1.fullCalculateY(1.26453));
        System.out.println();


        System.out.println("Task 2:");
        Task2 myTask2 = new Task2();
        String[] strArgs = InOut.readFromConsole();
        double[] doubleArgs = Util.convertStringsToNums(strArgs);
        double a = doubleArgs[0], b = doubleArgs[1];
        System.out.print("Task A2 (IN from console passed as variables converted by Double.parseDouble(), OUT println): y = ");
        System.out.println(myTask2.calculateY(a, b));
        System.out.println("Task A2 (IN as program args converted by Double.valueOf(), OUT concatenated println): y = " +
                Double.toString(myTask2.calculateY(Double.valueOf(args[0]), Double.valueOf(args[1]))));
        System.out.printf("Task A2 (IN as literal args, OUT printf: y = %10.6f)\n", myTask2.calculateY(0.3, -21.17));
        System.out.println();


        System.out.println("Task 3:");
        Task3 myTask3 = new Task3();
        double x = 3.567, start = 3.5, end = 25.5, delta = 3.75;
        myTask3.tabulateY(x, start, end, delta);
        System.out.println();


        System.out.println("Task 4:");
        Task4 myTask4 = new Task4();
        a = 2.408; start = 0.2; end = 0.4; delta = 0.02;
        System.out.printf("%.1f <= b <= %.1f, delta = %.2f: z = %10.6f\n", start, end, delta, myTask4.calculateZ(a, start, end, delta));
        System.out.println();


        System.out.println("Task 5:");
        Task5 myTask5 = new Task5();
        start = -6; end = 2; delta = 0.5;
        Task5.calculateAlpha(start, end, delta);
        System.out.println();


        System.out.println("Task 6:");
        Task6 myTask6 = new Task6();
        start = 0; end = 8;
        double[] m = myTask6.createArray(start, end);
        InOut.printArray(m, "m", 5);

        System.out.printf("Average of last 10 elements: %8.5f\n",
                myTask6.calculateAverageArraySlice(m, m.length-10, m.length));

        InOut.printArray(myTask6.createArrayFromArray(m), "M", 5);
    }

}

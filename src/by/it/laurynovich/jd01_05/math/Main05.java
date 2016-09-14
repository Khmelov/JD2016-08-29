package by.it.laurynovich.jd01_05.math;

import by.it.laurynovich.jd01_04.InOut;

/**
 * Created by vseotdala on 11.09.2016.
 */
public class Main05 {
    public static void main(String[] args) {

        System.out.println("Task_1");
        double x = 10.093;
        double a = 0.94;
        double z = Task_1.MathA1(x, a);
        System.out.println("z = "+ z);
        double z1 = Task_1.MathA2(x, a);
        System.out.println("z1 = "+ z1);
        System.out.println();

        //Task_2
        System.out.println("Task_2");
        System.out.println("z2 = "+ Task_2.MathT2(5.8,3.24));
        System.out.println();

        //Task_3
        System.out.println("Task_3");
        Task_3.Math03();
        System.out.println();

        //Task_4;
        System.out.println("Task_4");
        Task_4.Math_04();
        System.out.println();

        // Task_5;
        System.out.println("Task_05");
        double r = 4.73;
        System.out.println("z = " +Task_5.Math05(r));
        System.out.println();

        //Task_6;
        System.out.println("Task_6");
        double a2 = -1.2;
        double b = 2.7;
        Task_6.Math06(a2, b);


    }
}

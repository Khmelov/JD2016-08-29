package by.it.grishechkin.jd01_05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yury on 19.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        // Task1
        System.out.println(Task1.dissectedV(1.21, 0.371));
        System.out.println(Task1.fullV(1.21, 0.371));
        //Task2
        System.out.println(Task2.calc(23.55, 0.9));
        System.out.println("Enter a:");
        double a = Double.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Enter x:");
        double x = Double.valueOf(new Scanner(System.in).nextLine());
        System.out.println(Task2.calc(a, x));
        //Task3
        Task3.tabulate(2,3,0.1);
        //Task4
        Task4.mySum(1,8,1);
        //Task5
        Task5.func(-8,22,3.5);
        //Task6
        double [] arr = Util.addArr(0,8,0.3);
        Task6.printArr(arr);
        System.out.println();
        Task6.mean(arr);
        Task6.mod3(arr);
    }
}

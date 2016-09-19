package by.it.rudzko.jd01_05;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
	// Variant 9
        double a=756.13;
        double x=0.3;
        System.out.println("If a="+a+" and x="+x+" then z="+calculation.task1(a, x)+".");
        System.out.println("\nTask 2:\n");
        double y[]={1.21, 0.371};
        System.out.println("If a=1.21 and b=0.371 then y="+calculation.task2(y)+".");
        System.out.println("Now please enter your values for a and b. Use space to split numbers.");
        double c[]=InOut.getValues();
        System.out.println("For these values y="+calculation.task2(c)+".");
        double ar [][]=calculation.task3(12.1,-5,12,3.75);
        InOut.arPrint(ar);
        System.out.println("The summa of all values is "+calculation.task4(1,8,1));
        double ar2[][]=calculation.task5(0.491E4, -2.0, 15.0, 1.5);
        InOut.arPrint(ar2);
        System.out.println("\nTask 6:\n");
        System.out.println("Please enter an interval for the function between 0.09 and 0.2");
        double typed=Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.printf("Results for z=pow((x*x+4.5), 0.333) where 5.33<x<9 and interval is "+typed+"\n\n");
        double mas[]=calculation.task6(typed);
        InOut.arPrint(mas, "z", 5);
        System.out.println("The geometrical mean of these values is "+calculation.findGM(mas));



    }
}

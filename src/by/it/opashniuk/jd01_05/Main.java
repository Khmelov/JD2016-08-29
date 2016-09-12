package by.it.opashniuk.jd01_05;
import by.it.opashniuk.jd01_05.math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        double x=0.3;
        System.out.println("variant A: z= "+Task1.variantA(x));
        System.out.println("variant B: z= "+Task1.variantB(x));

        System.out.println("Задание 2");
        System.out.println("y= "+Task2.calculate(0.3,-21.17));

        System.out.println("Задание 3");
        Task3.tabul();

        System.out.println("Задание 4");
        System.out.println("m="+Task4.cikl());
    }
}

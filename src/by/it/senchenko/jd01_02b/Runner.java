package by.it.senchenko.jd01_02b;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите начальое число диапозона:");
        double x1 = in.nextDouble();
        System.out.println("Введите конечное число диапозона:");
        double x2 = in.nextDouble();
        System.out.println("Введите число для проверки нахождения его в диапооне:");
        double x =in.nextDouble();
        System.out.println("Начальное число = "+x1+", конечное число = "+x2+", проверяемое число = "+x+".");
        if(x1<=x && x<=x2)
            System.out.println("Число "+x+" принадлежит к диапозону от "+x1+" до "+x2+".");
        else
            System.out.println("Число "+x+" не принадлежит к диапозону от "+x1+" до "+x2+".");
    }
}

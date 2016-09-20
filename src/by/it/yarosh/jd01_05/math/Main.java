package by.it.yarosh.jd01_05.math;

import static  java.lang.Math.*;

public class Main {



    public static void main(String[] args) {
        double a = 1.21;
        double b = 0.371;
        System.out.println("С разбивкой выражения на части(1) y= " + Task1.separ(a, b));
        System.out.println("Полным выражением(1) y= " + Task1.tog(a, b));

        double x =0.9;
        System.out.println("Вычислил функцию(2) z=" +Task2.funct(a*19.4628099, x));
        System.out.println("Tабулирование функции y(3)");Task3.functab();
        System.out.println("Вложенные циклы(4): " +Task4.proiz());


    }
}

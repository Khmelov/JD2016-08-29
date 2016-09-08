package by.it.emelyanov.jd01_05;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        double a = 0.94;
        //double x = 10.093;//неверно указано значение для arccos
        double x = 0.093;
        System.out.println("С разбивкой(Задание 1) z= " + Task1.separ(a, x));
        System.out.println("Полное выражение(Задание 1) z= " + Task1.tog(a, x));
        //Задание 2
        System.out.println("Результат функции(Задание 2) z=" + Task2.funct(a * pow(10, -3), x));
        //Задание 3
        System.out.println("Результат табулирования функции(Задание 3)");
        Task3.functab();
        //Задание 4
        System.out.println("Вычисление произведения(Задание 4): "+Task4.proiz());
        //Задание 5
        System.out.println("Результат вычисления функции(Задание 5)");
        Task5.funct2();
    }
}

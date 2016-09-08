package by.it.emelyanov.jd01_02;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел");
        String line = scanner.nextLine();
        int arr[] = Util.lineToIntArray(line);
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);

        double mean = TaskA.mean(arr);
        System.out.print("Числа меньше " + mean + " таковы: ");
        for (int i : arr) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                break;
            }
        }
        //B1.
        int k = 5;
        TaskB.getAffiliations(k);
        //B2.
        int K = 6;
        TaskB.getArray(K);
        //B3.
        System.out.println("Находеним корни квадратного уравнения по формуле ax^2 + bx + c = 0, a != 0");
        System.out.println("Введите значение a= ");
        int a = scanner.nextInt();
        System.out.println("Введите значение b= ");
        int b = scanner.nextInt();
        System.out.println("Введите значение c= ");
        int c = scanner.nextInt();
        if (((b * b) - (4 * a * c)) < 0) {
            System.out.println("Корней нет.");
        }
        double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        {
            if (x1 == x2) {
                System.out.println("Корень один: " + x1);
            } else {
                System.out.println("Корни уравнения x1 = " + x1 + " и x2 = " + x2);
            }
        }
        //B4
        System.out.println("Введите число месяца:");
        int numb = scanner.nextInt();
        int x = numb;
        switch (x) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Неверный ввод числа месяца");
                break;
        }
    }
}

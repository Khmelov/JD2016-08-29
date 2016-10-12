package by.it.senchenko.jd01_02;


import java.util.Scanner;

public class TaskB4 {
    public static void main(String[] args) {
        String[] month = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12");
        if (in.hasNextInt()){
            int num = in.nextInt()-1;
            if (num >= 0 && num <= 11) {
                System.out.println(month[num]);
            } else {
                System.out.println("Введено не корректное число");
            }
        }else{
            System.out.println("Введено не целое число");
        }
    }
}

package by.it.senchenko.jd01_02;


import java.util.Scanner;

public class TaskB2 {
    public static void main(String[] args) {
        int count=1;
        int kPow;
        int k;
        Scanner in=new Scanner(System.in);
        System.out.println("Введите целое число");
        kPow=in.nextInt();
        System.out.println("Введенное число: "+kPow);
        k=kPow*kPow;
        System.out.println("Квадратом введенного числа будет: "+k);
        while (k>count){
            for (int i = 0; i < kPow; i++) {
                System.out.print(count+++"\t");
            }
            System.out.println();
        }
    }
}

package by.it.senchenko.jd01_02;


import java.util.Scanner;

public class TaskB3 {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        System.out.println("Решаем квадратное уравнение вида: ax*x+/-bx+/-c");
        Scanner in =new Scanner(System.in);
        System.out.println("Введите a");
        a=in.nextDouble();
        System.out.println("Введите b");
        b=in.nextDouble();
        System.out.println("Введите c");
        c=in.nextDouble();

        double d=b*b-4*a*c;
        if (d>0){
            double x1=(-b+Math.sqrt(d))/(2*a);
            double x2=(-b-Math.sqrt(d))/(2*a);
            System.out.println("Корни уравнения: "+x1+" и "+x2);
        }else {
            System.out.println("У уравнения нет корней");
        }
    }
}

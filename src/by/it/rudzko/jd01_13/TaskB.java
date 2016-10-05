package by.it.rudzko.jd01_13;

import java.util.Scanner;

/**
 * Created by user on 26.09.2016.
 */
public class TaskB {

    public static void heigth() throws ArithmeticException, NumberFormatException{
        System.out.println("Введите рост в сантиметрах:");
        double h=Double.parseDouble(new Scanner(System.in).nextLine())/100;
        if (h<0){
            ArithmeticException e=new ArithmeticException("Параметр не может принимать отрицательное значение.");
            throw e;
        }
        weight(h);
        System.out.println("Рост: "+h);
    }

    public static void weight(double d) throws ArithmeticException, NumberFormatException{
        System.out.println("Введите вес:");
        double w=Double.parseDouble(new Scanner(System.in).nextLine());
        if (w<0){
            ArithmeticException e=new ArithmeticException("Параметр не может принимать отрицательное значение.");
            throw e;
        }
        bmi(d,w);
        System.out.println("Вес: "+w);
    }

    public static void bmi(double d1, double d2){

        System.out.println("Индекс массы тела:");
        double res=0;
        try{
            res=d2/Math.pow(d1, 2);
            if (d1==0){
                ArithmeticException e=new ArithmeticException();
                throw e;
            }
            System.out.println(res);
        if (res<18.5)
        System.out.println("Дефицит массы тела.");
        else if (res>=18.5 && res<=25)
        System.out.println("Норма.");
        else if (res>25 && res<=35)
        System.out.println("Избыточная масса тела");
        else System.out.println("Ожирение");
    }
        catch (ArithmeticException e){
            System.out.println("Ошибка! Деление на ноль невозможно.");
        }
    }
}

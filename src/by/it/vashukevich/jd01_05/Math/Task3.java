package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;

/**
 * Created by Admin on 10.09.16.
 */
public class Task3 {
    static public void task3(){
        double x=12.1;
        System.out.println("==========================");
        System.out.println(String.format("%1s%10s%-2s%11s%2s","|","Параметр а","|","Результат y","|"));
        System.out.println("--------------------------");
        for(double a=3.5;a<=25.5;a+=2.5){
            double y= asin(x/2)+1.2*a;
            System.out.println(String.format("%1s%-10.3f%-2s%-11.3f%2s","|",a,"|",y,"|"));
        }
        System.out.println("==========================");
    }
}
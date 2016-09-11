package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;

/**
 * Created by Admin on 10.09.16.
 */
public class Task2 {
    static public void task2(){
        double a=0.3;
        double b=-21.47;
        double y=pow(1/tan(PI/4-4),4)+pow((a+1.5),3)-b/asin(pow(a,2));
        System.out.println("Задание 2: y="+y);
    }
}

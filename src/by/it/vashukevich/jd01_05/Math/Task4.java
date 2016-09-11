package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;

/**
 * Created by Admin on 10.09.16.
 */
public class Task4 {
    static public void task4(){
        double s=0;
        double d=0;
        for(double a=0;a<=2;a+=0.2){
            for(int x=1;x<=6;x++){
                double b=pow(7,a);
                s+=b;
                d=cosh(x);
            }
        }
        double y=s-d;
        System.out.println("y="+y);
    }
}

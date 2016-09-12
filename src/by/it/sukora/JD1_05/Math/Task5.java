package by.it.sukora.JD1_05.Math;

import static java.lang.Math.*;

/**
 * Created by stasi on 12.09.2016.
 */
public class Task5 {
    public static void yravnenie(double a){

        double x;
        for (double p = -2; p < 11; p += 3){

            if (1.5*p < 1.5){
                x = pow(acos(p),2);
            } else if (1.5*p >= 1.5 && 1.5*p < 3){
                x = pow(E,p)+3.5;
            } else if (1.5*p>3){
                x = p+4.76 ;
            } else{
                continue;
            }


            double y = a+1.39*x;

            System.out.println(String.format("%1s%25s", p, y));
        }
    }

}

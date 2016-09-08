package by.it.tsiamruk.jd01_05.math;

import static java.lang.Math.*;


public class Task5 {
    public static void functionCalculalation(){
        final double r = 4.73;


        for (double p = 0.5; p < 20; p+=3.5){
            double x = 0;
            if(pow(p,2) < 5){
                x = pow(sin(p),2);
            }

            if(pow(p, 2) >= 5 && pow(p, 2) < 13){
                x = pow(7, p+3);
            }

            if(pow(p,2) > 13){
                x = log(abs(pow((p + 4.7), 5)));
            }
            double z = x + r/2;
            System.out.println("Результат вычисления: " + z + "\nВеличина от которой зависит условие:" + p);
        }
    }
}

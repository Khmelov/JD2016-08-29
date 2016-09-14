package by.it.senchenko.jd01_05;


import static java.lang.Math.pow;

public class Main4 {
    public static void main(String[] args){
        double sum = 0;
        double a = 1.2; // в задании не указано значение a, для примера a = 1.2

        for (double t = 2; t <= 3; t += 0.1){
            for (int c = 12; c <= 43; c++){
                double x = pow(t,(a-3));
                sum += x;
            }
        }
        System.out.println(sum);

    }
}

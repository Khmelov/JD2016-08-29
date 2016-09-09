package by.it.tsiamruk.jd01_05.math;


public class Task4 {
    public static double additionMulti(){
        //calculating sum
        double a = 2.408;
        double sum = 0;

        for(double b = 0.2; b <= 0.4; b+=0.02){
            for(int c = 1; c <=12; c++)
                sum +=(c - b);
        }

        double z = 1.38 * a + sum;

        System.out.println(z);

        return z;


    }
}

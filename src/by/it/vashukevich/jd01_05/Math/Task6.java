package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;

/**
 * Created by Admin on 11.09.16.
 */
public class Task6 {
    static public double[] getMass(){
        int massLength=30;
        double[]mas=new double[massLength];
        for(double k=-3,j=0;k<2;k+=0.15,j+=1){
            mas[(int)j]=log10(abs(k+6));
            if(j==massLength-1)
                break;
        }
        return mas;
    }
    //private double getlastMas(double []mas){

   // }
}

package by.it.senchenko.jd01_05;

import static java.lang.Math.*;


public class Main5 {
    public static void main(String[] args){
        double r = 4.73;
        double x;
        for (double p = -6; p < 25; p += 4){

            if (p+r<0.5){
                x = pow(sin(r),3);
            } else if (0.5<=p+r && p+r<3){
                x = 0;
            } else if (p+r>3){
                x = sqrt(r+87.34);
            } else{
                continue;
            }
            double z = x+1/2;
            System.out.println(String.format("%1s%25s", p, z));
        }
    }

}

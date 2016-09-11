package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;

/**
 * Created by Admin on 10.09.16.
 */
public class Task1 {
   public static void mathExpenssion1() {
        double x=234.1;
        double a=sin(PI/2+1);
        double b=pow(a,2);
        double c=x*pow((3+pow(x,2)),1/4);
        double d=pow(tan(pow(x,3)-1),3);
        double e=atan(x/2);
        double g=log(17.56);
        double y1=(b+c-d)/(e-g);
        System.out.print("y1= "+y1);
   }

   static public void mathExpenssion2(){
       double x=234.1;
       double y=((pow(sin(PI/2+1),2))+x*pow((3+pow(x,2)),1/4)
               -pow(tan(pow(x,3)-1),3))/(atan(x/2)-log(17.56));
       System.out.println("y2= "+y);
   }
}

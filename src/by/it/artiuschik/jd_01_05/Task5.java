package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;
class Task5 {
    static double[][] calculateFunction(double left, double right, double step, double r) {
        double p = left + step;
        double z=0;
        int size = (int) (abs(right - left) / step);
        double[] functionValues = new double[size];
        double[] pValues=new double[size];
        for (int i = 0; i < functionValues.length; i++) {
            if((p-1)<0)
            {
                z=p-3.18*cos(p+1);
            }
            else
            {
               if(((p-1)<3)&&((p-1)>=0))
               {
                   z=pow(p,3)-tan(p);
               }
               else
               {
                   if((p-1)>=3)
                   {
                       z=pow((p+sin(PI/6)),5);
                   }
               }
            }
            functionValues[i]=sqrt(abs(z-2.56*r));
            pValues[i]=p;
            p+=step;
        }
        double[][] res=new double[functionValues.length][2];
        res[0]=functionValues;
        res[1]=pValues;
        return res;
    }
}




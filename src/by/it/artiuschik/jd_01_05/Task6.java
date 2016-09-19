package by.it.artiuschik.jd_01_05;
import by.it.artiuschik.jd_01_02.*;

import static java.lang.Math.*;
public class Task6 {
    public static double[] functionValues(double left,double right)
    {
        /* функция s=arcsin(i/2)*/
        double[] res=new double[25];
        double[] temp=new double[25];
        double step=abs(right-left)/25;
        double arg=left;
        for(int i=0;i<res.length;i++)
        {
            res[i]=(double)round(asin(arg/2)*10000)/10000;//округление до 10^-4
            arg+=step;
        }
        return res;
    }
    static public void printOddElements(double[] mas,String name)
    {
        for(int i=0;i<mas.length;i++)
        {
            if((mas[i]*10000)%2!=0)
            {
                System.out.print(name);
                System.out.printf("[% -3d]=%-9.4f ",i,mas[i]);
                System.out.println();
            }

        }
    }
    static public double srednGeom(double[] mas) {
        double srednGeom=1;
        for(int i=0;i<mas.length;i++)
        {
            if((mas[i]*10000)%2==0)
            {
                srednGeom*=mas[i];
            }

        }
        return srednGeom;
    }
}

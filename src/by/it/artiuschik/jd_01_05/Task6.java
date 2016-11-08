package by.it.artiuschik.jd_01_05;

import static java.lang.Math.*;
class Task6 {
    static double[] functionValues(double left, double right)
    {
        /* функция s=arcsin(i/2)*/
        double[] res=new double[25];
        double step=abs(right-left)/25;
        double arg=left;
        for(int i=0;i<res.length;i++)
        {
            res[i]=(double)round(asin(arg/2)*10000)/10000;//округление до 10^-4
            arg+=step;
        }
        return res;
    }
    static void printOddElements(double[] mas, String name)
    {
        for(int i=0;i<mas.length;i++)
            if ((mas[i] * 10000) % 2 != 0) {
                System.out.print(name);
                System.out.printf("[% -3d]=%-9.4f ", i, mas[i]);
                System.out.println();
            }
    }
    static double srednGeom(double[] mas) {
        double srednGeom=1;
        for (double ma : mas) {
            srednGeom = ((ma * 10000) % 2 == 0) ? srednGeom * ma : srednGeom;

        }
        return srednGeom;
    }
}

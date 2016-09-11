package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;
public class Task4 {
    public static double calculateFunction(double left,double right,double step)
    {
        double res=0;
        double d=1;
        double a=left;
        int size=(int)(abs(right-left)/step)+1;
        for(int i=0;i<size+1;i++)
        {
            for(int j=1;j<4;j++) {
                d *= sin(a - j);
            }
            res+=d;
            a+=step;
        }
        return res;
    }
}

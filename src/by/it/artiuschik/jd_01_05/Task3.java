package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;
class Task3 {
    static void functionTabulation(double x, double step, double left, double right)
    {
        int size=(int)abs(((right-left)/step))+1;
        double lef=left;
        double[] function=new double[size];
        double[] argument=new double[size];
        for (int i = 0; i < size; i++) {
            function[i]=pow(Math.E,lef*x)-3.45*lef;
            argument[i]=lef;
            lef+=step;
        }
        System.out.print("x: ");
        for(int i=0;i<size;i++){
            System.out.printf("%8.3f|",argument[i]);
        }
        System.out.println();
        System.out.print("y: ");
        for(int i=0;i<size;i++){
           System.out.printf("%8.3f|",function[i]);
        }
        System.out.println();
    }
}

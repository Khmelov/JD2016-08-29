package by.it.sukora.JD1_05.Math;

/**
 * Created by stasi on 08.09.2016.
 */
public class Task1 {

    public static void T1_1()
    {
        double a = 0.3;
        double b = -21.17;
        double y = 0;

        double c,d,k,j;

        c=Math.pow((Math.cos(Math.PI)/Math.sin(4)-1),4);
        d=Math.pow(Math.pow(a+1.5,1/3),3);
        k=Math.pow((a-b),8);
        j=(b/Math.asin(Math.pow(Math.abs(a),2)));

        y = c+d+k-j;
        y = Math.round(y);
        System.out.println("A= "+a);
        System.out.println("B= "+b);
        System.out.println("Решение уравнения= "+y);

    }

    public static void T1_2()
    {
        double a = 0.3;
        double b = -21.17;
        double y = 0;
        y =     Math.pow((Math.cos(Math.PI)/Math.sin(4)-1),4)+Math.pow(Math.pow(a+1.5,1/3),3)+Math.pow((a-b),8)-(b/Math.asin(Math.pow(Math.abs(a),2)));
        y = Math.round(y);
        System.out.println("A= "+a);
        System.out.println("B= "+b);
        System.out.println("Решение уравнения= "+y);

    }
}

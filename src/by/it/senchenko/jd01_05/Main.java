package by.it.senchenko.jd01_05;

import static java.lang.Math.*;



public class Main {
    public static void main(String[] args){
        double a;
        double b;
        double c;
        double y;
        double x = 1;
        // при double x = 12.75; будет NaN для примера будет 1

        a= sin(pow((PI/8-1),2))+pow((3+x*x),(1/4)); //переделать
        b = asin(x/2)-(5.236*pow(10,-2));
        c = log(abs(3.12-x));
        //Вычисляем
        y=a/b+c;
        System.out.println(y);
        double oneLine = (sin(pow((PI/8-1),2))+pow((3+x*x),(1/4)))/(asin(x/2)-(5.236*pow(10,-2)))+(log(abs(3.12-x)));
        System.out.println(oneLine);
    }
}

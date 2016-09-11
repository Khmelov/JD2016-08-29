package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;
public class Task2 {
 public static double calculateFunction(double a,double b)
 {
    double y=(pow((a+1.5),1/3))+pow((a-b),8)-(b/asin(pow(abs(a),2)));
    return y;
 }
}

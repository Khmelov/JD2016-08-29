package by.it.artiuschik.jd_01_05;
import static java.lang.Math.*;
class Task2 {
 static double calculateFunction(double a, double b)
 {
     return (pow((a+1.5),1/3))+pow((a-b),8)-(b/asin(pow(abs(a),2)));
 }
}

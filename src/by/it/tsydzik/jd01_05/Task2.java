package by.it.tsydzik.jd01_05;

import static java.lang.Math.*;

/**
 * @author Eugene Tsydzik
 * @since 11.9.16.
 */
public class Task2 {
	public static void compute() {
		double x = 3.24;
		double a = 5.8;

		double z = atan(pow(x, 2)) + (pow((cos(PI / 2 - a)), 3) / (abs(x - pow(a, 1d / 5))));
		System.out.println(z);
	}
}

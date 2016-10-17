package by.it.tsydzik.jd01_05;

import static java.lang.Math.*;

/**
 * @author Eugene Tsydzik
 * @since 11.9.16.
 */
public class Task1 {
	public static void compute() {
		double a = 1.21;
		double b = 0.371;

		double y;

		double part1 = tan(pow(a + b, 2));
		double part2 = pow((a + 1.5), 1d / 3);
		double part3 = a * pow(b, 5);
		double part4 = b / (log((pow(a, 2))));


		y = part1 - part2 + part3 - part4;
		System.out.println(y);


	}
}

package by.it.tsydzik.jd01_05;

import static java.lang.Math.*;

/**
 * @author Eugene Tsydzik
 * @since 11.9.16.
 */
public class Task3 {
	public static void compute() {
		double x = 12.1;
		double start = -10.0;
		double end = 1;
		double del = 0.5;

		System.out.println("------------------------------");
		System.out.println("| param |        value       |");
		System.out.println("------------------------------");

		for (double c = start; c <= end; c += del) {
			double l = pow((abs(2d * x - c)), 3d / 5) + 0.567;
			System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "|", c, "|", l, "|"));
		}

		System.out.println("------------------------------");
	}
}

package by.it.tsydzik.jd01_04;

public class Main {

	// задание a3
	public static void main(String[] args) {
		double[][] a = {
				{2, 5, 4, 1},
				{1, 3, 2, 1},
				{2, 10, 9, 7},
				{3, 8, 9, 2}
		};

		double[] y = {20, 11, 40, 37};

		double[][] identityMatrix = {
				{1, 0, 0, 0},
				{0, 1, 0, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 1}
		};

		double[] x = Helper.findRoot(a, y, identityMatrix);

		System.out.println("Roots");
		InOut.printArr(x);

		System.out.println("Determinant = " + Helper.det(a));

		System.out.println("\njd04: 3 task");
		double[] yy = Helper.mulArrVer(a, x);
		InOut.printArr(yy);

	}


}

package by.it.tsydzik.jd01_04;

/**
 * Created by user on 05.09.2016.
 */
public class Helper {
	static double[] findRoot(double[][] a, double[] y, double[][] identityMatrix) {
		double[] x = new double[y.length];
		// подготовка операционной матрицы
		int n = a.length;
		double[][] m = new double[n][n * 2 + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = a[i][j];
			}
			m[i][n] = y[i];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j + n + 1] = identityMatrix[i][j];
			}
		}

		InOut.printArr(m);


		// прямой ход Гаусса
		System.out.println("Прямой ход");
		for (int diag = 0; diag < n - 1; diag++) {
			for (int row = diag + 1; row < n; row++) {
				double k = m[row][diag] / m[diag][diag];
				for (int col = 0; col < n + 1; col++) {
					m[row][col] = m[row][col] - m[diag][col] * k;
				}
			}
		}
		InOut.printArr(m);

		// обратный ход Жордана
		System.out.println("Обратный ход");
		for (int diag = n - 1; diag > 0; diag--) {
			for (int row = 0; row < diag; row++) {
				double k = m[row][diag] / m[diag][diag];
				for (int col = 0; col < n + 1; col++) {
					m[row][col] = m[row][col] - m[diag][col] * k;
				}
			}
		}
		InOut.printArr(m);


		// Решение системы (приведение последней колонки)
		// (последнюю  колонку делим на диагональ)
		// приводим главную диагональ к 1
		System.out.println("Решение системы");
		for (int i = 0; i < n; i++) {
			double div = m[i][i];
			for (int j = 0; j < n + 1; j++) {
				m[i][j] = m[i][j] / div;
				x[i] = m[i][j];
			}
		}
		InOut.printArr(m);


		return x;
	}

	// часть B
	static double det(double[][] m) {
		double[][] matrix = m;
		int n = matrix.length;
		for (int diag = 0; diag < n - 1; diag++) {
			for (int row = diag + 1; row < n; row++) {
				double k = matrix[row][diag] / matrix[diag][diag];
				for (int col = 0; col < n; col++) {
					matrix[row][col] = matrix[row][col] - matrix[diag][col] * k;
				}
			}
		}
		double res = 1;
		for (int i = 0; i < n; i++) {
			res = res * matrix[i][i];

		}
		return res;
	}

	static double[] mulArrVer(double[][] a, double[] x) {
		double[] y = new double[a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < x.length; j++) {
				y[i] = y[i] + a[i][j] * x[j];
			}
		}
		return y;
	}

	public static double[][] arrayMulVector(double[][] x, double[][] y) {
		double[][] z = new double[x.length][y[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				for (int k = 0; k < y.length; k++) {
					x[i][j] = z[i][j] + x[i][k] * y[k][j];
				}
			}
		}
		return z;
	}
}

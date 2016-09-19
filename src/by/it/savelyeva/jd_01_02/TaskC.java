package by.it.savelyeva.jd_01_02;

public class TaskC {
	public final int[][] inputMatrix;
	int size;
	
	public TaskC(int[][] intSquareMatrix) {
		this.inputMatrix = intSquareMatrix;
		this.size = intSquareMatrix[0].length;
	}

	public int[] getSumsBetweenTwoPositivesInRows() {
		int[] resultSums = new int[this.size];
		System.out.print("Sums between two positives in each row are: ");
		for (int i=0; i<this.size; i++) {
			resultSums[i] = 0;
			int j = 0;
			try {
				while (this.inputMatrix[i][j]<=0) {
					j++;
				}
				do {
					resultSums[i] += this.inputMatrix[i][j];
					j++;
				} while (j==this.size || this.inputMatrix[i][j]<0);
				if (j<this.size && this.inputMatrix[i][j]>0) {
					resultSums[i] += this.inputMatrix[i][j];
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				resultSums[i] = Integer.MIN_VALUE;
			}
			System.out.printf("%d ", resultSums[i]);
		}
		System.out.println();
		System.out.println("Note: Integer.MIN_VALUE is displayed for rows which have <2 positives");
		return resultSums;
	}
	public void transposeMatrix() {
		int[][] transposedMatrix = new int[this.size][this.size];
		for (int i=0; i<this.size; i++) {
			transposedMatrix[i] = this.inputMatrix[i].clone();
		}
		for (int i=0; i<this.size; i++) {
			for (int j=i; j<this.size; j++) {
				int tmp = transposedMatrix[i][j];
				transposedMatrix[i][j] = transposedMatrix[j][i];
				transposedMatrix[j][i] = tmp;
			}
		}
		System.out.println("Transposed Matrix:");
		new Util().printSquareMatrix(transposedMatrix);
		System.out.println("Original Matrix:");
		new Util().printSquareMatrix(this.inputMatrix);
	}
	public void rotate90Matrix() {
		int[][] rotatedMatrix = new int[this.size][this.size];
		for (int i=0; i<this.size; i++) {
			for (int j=0; j<this.size; j++) {
				rotatedMatrix[i][j] = this.inputMatrix[j][i];
			}
		}
		for (int i=0; i<this.size/2; i++) {
			for (int j=0; j<this.size; j++) {
				int tmp = rotatedMatrix[j][i];
				rotatedMatrix[j][i] = rotatedMatrix[j][this.size-i-1];
				rotatedMatrix[j][this.size-i-1] = tmp;
			}
		}
		System.out.println("Rotated Matrix:");
		new Util().printSquareMatrix(rotatedMatrix);
		System.out.println("Original Matrix:");
		new Util().printSquareMatrix(this.inputMatrix);
	}
}

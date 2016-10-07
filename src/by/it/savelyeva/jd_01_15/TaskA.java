package by.it.savelyeva.jd_01_15;
/**
 * Created by nato on 9/30/16.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Random;

public class TaskA {
	private int dim;
	private int leftBound;
	private int rightBound;
	private int[][] matrix;
	
	public TaskA(int dim, int leftBound, int rightBound) {
		this.dim = dim;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.matrix = new int[dim][dim];
	}
	
	public void fillMatrix() {
		Random rnd = new Random();
		for (int i=0; i<dim; i++) {
			for (int j=0; j<dim; j++) {
				this.matrix[i][j] = this.leftBound + rnd.nextInt(this.rightBound - this.leftBound)+1; 
			}
		}
	}

	public void printMatrix() {
		for (int i=0; i<dim; i++) {
			for (int j=0; j<dim; j++) {
				System.out.printf("%3.0f ", (double) this.matrix[i][j]); 
			}
			System.out.println();
		}
	}
	
	public void printMatrix(String filename) {
		Formatter formatter = null;
		try (PrintWriter printer = new PrintWriter(new FileWriter(filename, false))) {
			for (int i=0; i<dim; i++) {
				for (int j=0; j<dim; j++) {
					formatter = new Formatter();
					String s = formatter.format("%3.0f ", (double) this.matrix[i][j]).toString();	
					printer.append(s); 
				}  
				printer.println("\n");
			}
			printer.println();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if (formatter != null) formatter.close();
	}
}

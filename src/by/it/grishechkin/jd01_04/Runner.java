package by.it.grishechkin.jd01_04;

/**
 * Created by Yury on 18.09.2016.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("\nEnter matrix line count");
        int strCount = Integer.valueOf(InOut.consoleReadLine());
        String [] matrix = new String[strCount];
        System.out.println("\nEnter matrix lines");
        for (int i = 0; i < strCount; i++) {
            matrix[i] = InOut.consoleReadLine();
        }
        for (int i = 0; i < strCount; i++) {
            System.out.println(matrix[i]);
        }
        double[][] mas = new double[strCount][];
        double[][] mass = new double[strCount][];
        double[][] mass3 = new double[strCount][];
        for (int i = 0; i < strCount; i++) {
            mas[i] = InOut.arrayFromString(matrix[i]);
            mass[i] = InOut.arrayFromString(matrix[i]);
            mass3[i] = InOut.arrayFromString(matrix[i]);
        }

        System.out.println("\nEnter coefficients vector");
        String line = InOut.consoleReadLine();
        System.out.println(line);
        double b[] = InOut.arrayFromString(line);
        System.out.println("Solve: ");
        double [] x = Util.findRoot(mas, b);
        for (double elem : x) {
            System.out.print(elem + "\t");
        }

        System.out.println("\nChecking: ");
        Util.multipleMV(mass, x);

        System.out.println("Determinant: " + Util.findDeterminant(mass));

        System.out.println("Inverse matrix: ");
        double[][] A = Util.inverseMatrix(mass);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Checking 2: ");
        Util.multiple(mass3, A);
    }
}

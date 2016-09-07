package by.it.savelyeva.jd_01_04;

public class Main {

    public static void main(String[] args) {
        double[][] matrixA = {
                {3, 2, 1},
                {2, 3, 1},
                {2, 1, 3}
        };
        double[] vectorB = {5, -1, 4};

        double[] vectorX;

        vectorX = Util.findRootGaussian(matrixA, vectorB);

        System.out.println("Check A*X = B :");

        double[] vectorY = Util.arrayMulVector(matrixA, vectorX);
        System.out.println("Solution: ");
        InOut.arrayPrint(vectorY);
        System.out.println("Check vectorB == vectorY : ");
        System.out.println(Util.arraysEqual(vectorB, vectorY));

        System.out.printf("Determinant of matrixA: %10.6f \n", Util.findDeterminant(matrixA));

        System.out.println("Inverse of matrixA: ");
        double[][] inversedMatrix = Util.inverseMatrix(matrixA);
        InOut.arrayPrint2D(inversedMatrix);

        double[][] multipliedMatrix = Util.arrayMulVector(matrixA, inversedMatrix);
        System.out.println("MatrixA * Inverse of matrixA = ");
        InOut.arrayPrint2D(multipliedMatrix);
        System.out.println("Check matrixA*inversedMatrixA == matrixE : ");
        System.out.println(Util.matrixIsE(multipliedMatrix));



        ////////////////////////////////////////////////
        System.out.println("Below are tasks on arrays implemented in class:");
        //String line = InOut.consoleReadLine();
        String line = "1 2 3 123 1 2 3 45";
        System.out.println(line);
        double mas[] = InOut.arrayFromString(line);
        InOut.arrayPrint(mas, "m", 3);

        System.out.print("Min element: ");
        System.out.println(Util.minDoubleArray(mas));
        System.out.print("Max element: ");
        System.out.println(Util.maxDoubleArray(mas));

        System.out.println("Sorted array (bubble): ");
        mas = Util.sortBubble(mas);
        InOut.arrayPrint(mas);
        InOut.arrayPrint(mas, "m", 3);

        System.out.println("Sorted array (unisort): ");
        mas = Util.uniSort(mas, false);
        InOut.arrayPrint(mas);
        InOut.arrayPrint(mas, "m", 3);

        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        InOut.arrayPrint2D(m, "m");
        InOut.arrayPrint2D(m);

        double[] y = {1, 2, 3, 4};

        double[] x = Util.arrayMulVector(m, y);
        System.out.print("Transposed result of matrix * vector: ");
        InOut.arrayPrint(x);
        System.out.println();

        double[][] xx = Util.arrayMulVector(m, m);
        System.out.println("Result of matrix * matrix:");
        InOut.arrayPrint2D(xx);

        ////////////////////////////////////////////////////
        System.out.printf("Determinant of the above matrix: %10.6f \n", Util.findDeterminant(m));

        System.out.println("Inverse of matrix : ");
        inversedMatrix = Util.inverseMatrix(m);
        InOut.arrayPrint2D(inversedMatrix);
    }
}

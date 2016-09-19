package by.it.laurynovich.jd01_04;

import java.io.IOException;

/**
 * Created by vseotdala on 05.09.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        double a[][] = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };

        double b[][] = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        double y[] = {20, 11, 40, 37};
        double x[] = Helper.findRoot( a, y, true );
        System.out.println( "Roots" );
        InOut.printArr( x );

        double pr[] = Helper.mulArrVec( a, x );
        System.out.println( "проверка решения:" );
        InOut.printArr( pr );

        double[][] m = Helper.findRoot2( a, y, true );
        double det = Helper.det( m );
        System.out.println( "Det = " + det );

        double[][] a1 = Helper.getInverseMatrix( a, b, true );
        System.out.println( "inverse matrix" );
        InOut.printArr( a1 );

        System.out.println( "проверка обратной матрицы" );
        double[][] E = Helper.mulArrArr( a1, a );
        InOut.printArr( E );

    }
}
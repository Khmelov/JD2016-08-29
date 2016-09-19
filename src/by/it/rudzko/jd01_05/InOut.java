package by.it.rudzko.jd01_05;

import java.util.Scanner;

/**
 * Created by Kir on 09.09.2016.
 */
public class InOut {
    public static double[] getValues(){
        String z=(new Scanner(System.in).nextLine()).trim();
        String abstr[]=z.split(" ");
        double ab[]={Double.parseDouble(abstr[0]), Double.parseDouble(abstr[1])};
        return ab;

    }
    public static void arPrint(double [][] x){
        System.out.printf("%60s%60s", "Variable", "Result");
        System.out.println("\n________________________________________________________________________________________________________________________________________");
        for (int i = 0; i < x.length; i++) {

                System.out.printf("| %60.5f |", x[i][0]);
                System.out.printf("| %60.5f |", x[i][1]);

            System.out.println();
        }
    }
    public static void arPrint(double x[], String name, int cols) {
        int c = 0;
        for (double value : x) {
            System.out.printf(name + "[%-2d]=%-10.2f ", c, x[c]);
            c++;
            if (c % cols == 0 || c == x.length)
                System.out.println();

        }
    }
}

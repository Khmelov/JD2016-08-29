package by.it.rudzko.jd01_04;

public class Runner {

    public static void main(String[] args) {
        int s=(int)(Math.random()*5+2);

        double a[][]=new double[s][s];
        double b[]=new double[s];
        for (int i=0; i<s; i++){
            for (int j=0; j<s; j++){
                a[i][j]=Math.round(Math.random()*8+2);
            }
        }

       for (int i=0; i<s; i++){
           b[i]=Math.round(Math.random()*8+1);
       }
        System.out.println("All calculations are valid for square matrixs only.");
        System.out.println("The generated matrix and vector are:");
        InOut.printAr(a);
        System.out.println();
        InOut.printAr(b);
        System.out.println("\nThe roots are:");
        double res[]=Util.getRes(a,b);
        InOut.printAr(res);
        System.out.println("\nTo check the roots we'll try to  multiplicate them and matrix:");
        InOut.printAr(Util.check(a, res), "b");
        System.out.println("\nThe determinant of generated matrix is "+Math.round(Util.findDet(a))+".");
        System.out.println("\n\nThis is the inverse matrix for generated matrix:\n");
        InOut.printAr(Util.findM(a));
        System.out.println("\nMultiplication of the inverse matrix and generated matrix:");
        InOut.printAr(Util.checkM(a, Util.findM(a)));
    }


}

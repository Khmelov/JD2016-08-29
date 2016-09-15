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
        System.out.println("The source 'a' and 'b' are:");
        InOut.printAr(a);
        System.out.println();
        InOut.printAr(b);
        System.out.println("\nThe result is:");
        double res[]=Util.getRes(a,b);
        InOut.printAr(res);
        System.out.println("\nTo check the result we'll try to return our vector back:");
        InOut.printAr(Util.check(a, res), "b");
        System.out.println("\nThe determinant of generated matrix is "+Math.round(Util.findDet(a))+".");
    }


}

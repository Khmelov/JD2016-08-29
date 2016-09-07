package by.it.tsiamruk.jd01_04;

public class Main {

    public static void main(String[] args) {
        double a[][]={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,12}
        };
        double y[]={20,11,40,37};
        double x[]=Util.findroot(a,y);
       // InOut.arrayPrint2D(a);
        System.out.println("Roots");
        InOut.arrayPrint(x);
        System.out.println("Determinant= "+Util.det(a));
        double[] yy=Util.mulArrVac(a,x);
        InOut.arrayPrint(yy);

    }

}

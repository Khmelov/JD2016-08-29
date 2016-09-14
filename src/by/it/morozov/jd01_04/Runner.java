package by.it.morozov.jd01_04;

/**
 * Created by BukTpbI4 on 13.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        double a[][]={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,12}
        };
        double y[]={20,11,40,37};
        double x[]=Helper.findRoot(a,y);
        System.out.println("Roots");
        InOut.arrayPrint(x);
        System.out.println("Determinant= " + Helper.det(a));
        double[] yy=Helper.mulArrVac(a,x);
        InOut.arrayPrint(yy);
    }
}

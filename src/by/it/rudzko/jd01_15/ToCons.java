package by.it.rudzko.jd01_15;

/**
 * Created by Leta on 01.10.2016.
 */
public class ToCons {
    public static void printAr(int[][]a){
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[0].length; j++){
                System.out.printf("%3d", a[i][j]);
                if (j!=a[0].length-1) System.out.print(" ");
                else System.out.print("\n");
            }
        }
    }
}

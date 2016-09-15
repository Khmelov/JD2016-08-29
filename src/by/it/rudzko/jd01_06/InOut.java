package by.it.rudzko.jd01_06;

/**
 * Created by Leta on 12.09.2016.
 */
public class InOut {
    public static void printAr(String[][]ar){

        for (int i=0; i<ar.length; i++){
            if (ar[i][0] != null) {
                System.out.printf("%-10s", ar[i][0]);
                if (ar[i][1]!=null) {System.out.printf("%4s", ar[i][1]);}
                System.out.println();
            }
        }
    }

    public static void printPoem (String[] s){
        for (String value: s){
            System.out.println(value);
        }
    }
}

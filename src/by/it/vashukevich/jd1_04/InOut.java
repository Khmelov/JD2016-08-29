package by.it.vashukevich.jd1_04;

/**
 * Created by Admin on 05.09.16.
 */
public class InOut {
    static void printArr(double[][]m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++ ){
                System.out.printf("%6.2f",m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

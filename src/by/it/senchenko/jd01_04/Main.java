package by.it.senchenko.jd01_04;

/**
 * Created by User on 07.09.2016.
 */
public class Main {
    public static void main(String[] args){
        double [] y={20,11,20,37};

        double[][] m={
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 2},
                {3, 8, 9, 2}
        };
        double[] x=Util.findRot(m,y,false);
        InOut.arrayPrint(x, "X", 1);
        //проверка
        InOut.arrayPrint(Util.arrayMulVector(m,x), "yy", 4);
    }
}

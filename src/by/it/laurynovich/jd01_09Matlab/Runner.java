package by.it.laurynovich.jd01_09Matlab;

/**
 * Created by vseotdala on 9/16/2016.
 */
public class Runner {
    public static void main(String[] args) {
        Var f1=new VarF(7);
        Var f2=new VarF(8);
        System.out.println("Cложение");
        System.out.println(f1.add(f2));
        System.out.println("Вычитание");
        System.out.println(f1.sub(f2));
        System.out.println("Умножение");
        System.out.println(f1.mul(f2));
        System.out.println("Деление");
        System.out.println(f1.div(f2));
        System.out.println();
        double[] val=new double[]{1,2,3};
        Var v1=new VarV(val);
        System.out.println(f1.add(v1));
        System.out.println(f1.sub(v1));
        System.out.println(f1.mul(v1));
        System.out.println(f1.div(v1));

        double [][] mas = {{1,2,3},{4,5,6},{7,8,9}};
        Var m1 = new VarM(mas);
        System.out.println("Cложение");
        System.out.println(m1.add(f1));
//        System.out.println("Вычитание");
//        System.out.println(f1.sub(mas));
//        System.out.println("Умножение");
//        System.out.println(f1.mul(mas));
//        System.out.println("Деление");
//        System.out.println(f1.div(mas));
//        System.out.println();

    }
}

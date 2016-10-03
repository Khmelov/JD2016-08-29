package by.it.laurynovich.jd01_09Matlab;

/**
 * Created by vseotdala on 9/16/2016.
 */
public class Runner {
    public static void main(String[] args) {
        Var f1 = new VarF(7);
        Var f2 = new VarF(8);

        System.out.println("Cложение");
        System.out.println(f1.add(f2));
        System.out.println("Вычитание");
        System.out.println(f1.sub(f2));
        System.out.println("Умножение");
        System.out.println(f1.mul(f2));
        System.out.println("Деление");
        System.out.println(f1.div(f2));
        System.out.println();

        System.out.println("Vector");
        double[] val = new double[]{1, 2, 3};
        double[] val1 = new double[]{9, 36, -3};
        Var v1 = new VarV(val);
        Var v2 = new VarV(val1);
        System.out.println("Cложение");
        System.out.println(f1.add(v1));
        System.out.println(v1.add(v1));
        System.out.println("Вычитание");
        System.out.println(v1.sub(f1));
        System.out.println(v1.sub(v2));
        System.out.println("Умножение");
        System.out.println(v1.mul(f1));
        System.out.println("Деление");
        System.out.println(v1.div(f1));
        System.out.println();

        System.out.println("Matrix");
        double[][] mas = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] mas2 = {{2, 3, 3}, {5, 2, 6}, {8, 9, 7}};
        Var m1 = new VarM(mas);
        Var m2 = new VarM(mas2);
        System.out.println("Cложение matrix & float");
        Var newM1 = m1.add(f1);
        System.out.println(newM1);
        System.out.println("Cложение matrix & matrix");
        System.out.println(m1.add1(m2));
        System.out.println("Деление matrix / matrix");
        System.out.println(m1.div(m2));
        System.out.println("Деление matrix / float");
        System.out.println(m2.div(f1));
        System.out.println("Вычитание matrix - float");
        System.out.println(m2.sub(f1));
        System.out.println("Умножение");
        System.out.println(m1.mul(m2));
        System.out.println("Деление matrix & float");

        System.out.println(m2.div(f2));
//        System.out.println();

    }
}

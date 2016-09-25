package by.it.vashukevich.jd01_09.mathlab;

/**
 * Created by Admin on 16.09.16.
 */
public class Runner {
    public static void main(String[] args) {
        //Var f2=new VarF(8);
        System.out.println("+-/* со скалярными величинами");
        System.out.println(new VarF(1).add(new VarF(2)));
        System.out.println(new VarF(7).sub(new VarF(8)));
        System.out.println(new VarF(5).mul(new VarF(8)));
        System.out.println(new VarF(8).div(new VarF(0)));


        double[] val=new double[]{1,2,3};
        //Var v1=new VarV(val);

        System.out.println("+-/* со скалярными величинами и векторами");
        System.out.println(new VarF(1).add(new VarV(val)));
        System.out.println(new VarF(3).sub(new VarV(val)));
        System.out.println(new VarF(1).mul(new VarV(val)));
        System.out.println(new VarF(1).div(new VarV(val)));

        System.out.println("+-*/ ");
        System.out.println(new VarV(val).add(new VarF(3)));
        System.out.println(new VarV(val).sub(new VarF(3)));
        System.out.println(new VarV(val).mul(new VarF(3)));
        System.out.println(new VarV(val).div(new VarF(3)));

        System.out.println("+-*/ с векторами");
        System.out.println(new VarV(val).add(new VarV(val)));
        System.out.println(new VarV(val).sub(new VarV(val)));
        System.out.println(new VarV(val).mul(new VarV(val)));
        System.out.println(new VarV(val).div(new VarV(val)));
    }
}

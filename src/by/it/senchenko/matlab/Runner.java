package by.it.senchenko.matlab;

/**
 * Created by User on 16.09.2016.
 */
public class Runner {
    public static void main(String[] args){
        Var f1=new VarF(7);
        Var f2=new VarF(8);
        System.out.println(f1.add(f2));
        System.out.println(f1.sub(f2));
        System.out.println(f1.mul(f2));
        System.out.println(f1.div(f2));
        double[] val=new double[]{1,2,3};
        Var v1=new VarV(val);
        System.out.println(f1.add(v1));
        System.out.println(f1.sub(v1));
        System.out.println(f1.mul(v1));
        System.out.println(f1.div(v1));
    }
}

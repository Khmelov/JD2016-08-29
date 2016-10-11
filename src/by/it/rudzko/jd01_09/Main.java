package by.it.rudzko.jd01_09;

import by.it.rudzko.jd01_09.Vars.Var;
import by.it.rudzko.jd01_09.Vars.VarMat;
import by.it.rudzko.jd01_09.Vars.VarNum;
import by.it.rudzko.jd01_09.Vars.VarVec;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("\nTask C:\n");
        Var a=new VarMat("{{1,2}, {8,3}}");
        Var b=new VarNum(2);
        Var c=new VarVec("{1,2}");
        Calculator calc=new Calculator();
        System.out.println(calc.sub(a,b).toString());
        System.out.println(calc.mul(a,c));
        System.out.println(calc.mul(a,a));
        System.out.println(calc.add(a,a));
        System.out.println("\nTask B:\n");
        Var d=new VarVec("{2,3,4}");
        Var e=new VarVec("{5,6,7}");
        Var f=new VarNum(3);
        Var g=new VarNum(5);
        Var h=new VarNum(-4);
        System.out.println(calc.mul(d,b));
        System.out.println(calc.div(d,f));
        System.out.println(calc.sub(d,g));
        System.out.println(calc.add(h,d));
        System.out.println(calc.add(d,e));
        System.out.println(calc.sub(d,e));
        System.out.println("\nTask A:\n");
        System.out.println(calc.add(new VarNum(3.8), new VarNum(26.2)));
        System.out.println(calc.sub(new VarNum(87.4), new VarNum(23.1)));
        System.out.println(calc.mul(new VarNum(1.04), new VarNum(5.9)));
        System.out.println(calc.mul(new VarNum(12.7), new VarNum(5)));
        System.out.println(calc.add(new VarNum(-6), new VarNum(12)));
        System.out.println(calc.mul(new VarNum(-7), new VarNum(3.1)));
        System.out.println(calc.div(new VarNum(-4), new VarNum(8)));
        System.out.println(calc.sub(new VarNum(-9), new VarNum(0.9)));


    }
}

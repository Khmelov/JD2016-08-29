package by.it.rudzko.Matlab;

public class Main {

    public static void main(String[] args) {

        try {
            Parser p1 = new Parser("{{1,2}, {8,3}}-2");
            p1.go();
            Parser p2 = new Parser("{{1,2}, {8,3}}*{1,2}");
            p2.go();
            Parser p3 = new Parser("{{1,2}, {8,3}}*{{1,2}, {8,3}}");
            p3.go();
            Parser p4 = new Parser("{{1,2}, {8,3}}+{{1,2}, {8,3}}");
            p4.go();
            Parser p5 = new Parser("16*(39-3)/(4+2)");
            p5.go();
            Parser p6 = new Parser("{4,2}*{{1,3}, {2,0}}");
            p6.go();

//        System.out.println("\nTask C:\n");
//        Var a=new VarMat("{{1,2}, {8,3}}");
//        Var b=new VarNum(2);
//        Var c=new VarVec("{1,2}");
//        Calculator calc=new Calculator();
//        System.out.println(calc.sub(a,b).toString());
//        System.out.println(calc.mul(a,c));
//        System.out.println(calc.mul(a,a));
//        System.out.println(calc.add(a,a));
//        System.out.println("\nTask B:\n");
//        Var d=new VarVec("{2,3,4}");
//        Var e=new VarVec("{5,6,7}");
//        Var f=new VarNum(3);
//        Var g=new VarNum(5);
//        Var h=new VarNum(-4);
//        System.out.println(calc.mul(d,b));
//        System.out.println(calc.div(d,f));
//        System.out.println(calc.sub(d,g));
//        System.out.println(calc.add(h,d));
//        System.out.println(calc.add(d,e));
//        System.out.println(calc.sub(d,e));
//        System.out.println("\nTask A:\n");
//        System.out.println(calc.add(new VarNum(3.8), new VarNum(26.2)));
//        System.out.println(calc.sub(new VarNum(87.4), new VarNum(23.1)));
//        System.out.println(calc.mul(new VarNum(1.04), new VarNum(5.9)));
//        System.out.println(calc.mul(new VarNum(12.7), new VarNum(5)));
//        System.out.println(calc.add(new VarNum(-6), new VarNum(12)));
//        System.out.println(calc.mul(new VarNum(-7), new VarNum(3.1)));
//        System.out.println(calc.div(new VarNum(-4), new VarNum(8)));
//        System.out.println(calc.sub(new VarNum(-9), new VarNum(0.9)));
        } catch (RuntimeException e) {
            System.out.println("Can't parse these variables. Please use positive numbers.");
        }
    }
}




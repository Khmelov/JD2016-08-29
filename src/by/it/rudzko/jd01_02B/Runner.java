package by.it.rudzko.jd01_02B;

public class Runner {

    public static void main(String[] args) {
        int k = (int)(Math.random()*100);
        System.out.println(k+" is generated for k.");
        int n=(int)(Math.random()*50);
        int m=(int)(Math.random()*50+51);
        System.out.println(n+" is generated for n.\n"+m+" is generated for m.");
        if (Util.Incl(k,n,m)==true){
            System.out.println("k="+k+" belongs to the interval between n="+n+" and m="+m+".\n\n");
        }
        else
            System.out.println("k="+k+" doesn't belong to the interval between n="+n+" and m="+m+".\n\n");
        ;
        int r=(int)(Math.random()*7+4);
        int k2=r*r;
        int array[]=Util.fillAr(k2);
        InOut.arPrint(array,5);
        System.out.println("Now please enter a number from 1 to 7 to get a day of week it matches.");
        int d=Util.getNum();
        Util.printDay(d);
        Calc.solveEq();



    }
}

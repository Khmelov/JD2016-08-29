package by.it.rudzko.jd01_08;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello! Let's try to fill your room with furniture. Please enter length of your room.");
        float lR=Float.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Please enter width of your room.");
        float wR=Float.valueOf(new Scanner(System.in).nextLine());
        float[]pr=new float[6];
        System.out.println("\nNow let's create a wardrobe.");
        Locker w=new Wardrobe();
        if(w.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        w.descr();
        w.descr(pr);
        float wsq=w.findSq();
        System.out.println("The square of the wardrobe is "+wsq);
        System.out.println(w.fitSize(lR,wR));
        System.out.println("\nNow let's create a sofa.");
        Seat s=new Sofa();
        if(s.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        s.descr();
        s.descr(pr);
        float ssq=s.findSq();
        System.out.println("The square of the sofa is "+ssq);
        System.out.println(s.fitSize(lR,wR));
        System.out.println("\nNow let's create a dinner table.");
        Table dt=new DinnerTable();
        if(dt.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        dt.descr();
        dt.descr(pr);
        float dtsq=dt.findSq();
        System.out.println("The square of the dinner table is "+dtsq);
        System.out.println(dt.fitSize(lR,wR));
        System.out.println("\nNow let's create an entresol.");
        Locker en=new Entresol();
        if(en.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        en.descr();
        en.descr(pr);
        float ensq=en.findSq();
        System.out.println("The square of the entresol is "+ensq+ " (it doesn't use an area at the floor).");
        System.out.println(en.fitSize(lR,wR));
        System.out.println("\nNow let's create an armchair.");
        Seat ch=new Chair();
        if(ch.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        ch.descr();
        ch.descr(pr);
        float chsq=ch.findSq();
        System.out.println("The square of the armchair is "+chsq);
        System.out.println(ch.fitSize(lR,wR));
        System.out.println("\nNow let's create a coffee table.");
        Table ct=new CoffeeTable();
        ct.getPar();
        ct.getPrice();
        if(ct.lessThanAv(pr)) System.out.println("Wow! It's cheap!");
        ct.descr();
        ct.descr(pr);
        float ctsq=ct.findSq();
        System.out.println("The square of the coffee table is "+ctsq);
        System.out.println(ct.fitSize(lR,wR));
        if (wsq+ssq+dtsq+ensq+chsq+ctsq<lR*wR){
            float free=lR*wR-(wsq+ssq+dtsq+ensq+chsq+ctsq);
            System.out.println("\nCongratulations! You have successfully filled your room! Now you have "+free+" free space in it.");
        } else System.out.println("Unfortunately, there's not enough free space in your room.");
    }
}

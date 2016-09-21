package by.it.rudzko.jd01_08;

import java.util.Scanner;

/**
 * Created by Leta on 18.09.2016.
 */
public abstract class Table implements IFurniture{

    private float l;
    private float w;

    private float p;

    @Override
    public void getPar() {
        System.out.println("Please enter length of the table.");
        String a=new Scanner(System.in).nextLine();
        System.out.println("Please enter width of the table.");
        String b=new Scanner(System.in).nextLine();

        this.l=Float.valueOf(a);
        this.w=Float.valueOf(b);

    }


    @Override
    public void getPrice() {
        System.out.println("Please enter price of the table.");
        this.p=Float.valueOf(new Scanner(System.in).nextLine());

    }

    @Override
    public boolean lessThanAv(float[] prices) {
        int count=0;
        for(int i=0; i<prices.length; i++){
            if (prices[i]!=0) count++;
        }

        float sum=0;
        for (int i=0; i<prices.length; i++){
            sum+=prices[i];
        }
        if (this.p<sum/count) return true;
        else return false;
    }

    @Override
    public abstract void descr();

    @Override
    public abstract void descr(float [] prices);

    @Override
    public float findSq() {
        return this.l*this.w;
    }

    @Override
    public String fitSize(float a, float b) {
        if (a>=this.l) return "Table fits width of the room.";
        else return "Table doesn't fit width of the room";
    }



    public float getL() {
        return l;
    }

    public float getW() {
        return w;
    }

    public float getP() {
        return p;
    }


}

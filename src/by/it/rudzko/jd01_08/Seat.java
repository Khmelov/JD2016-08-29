package by.it.rudzko.jd01_08;

import java.util.Scanner;

/**
 * Created by Leta on 18.09.2016.
 */
public abstract class Seat implements IFurniture{

    private float l;
    private float w;

    private float p;

    @Override
    public void getPar()throws IllegalArgumentException{
        System.out.println("Please enter length of the seat.");
        String a=new Scanner(System.in).nextLine();
        this.l=Float.valueOf(a);
        if (this.l<=0){
            throw new IllegalArgumentException();
        }
        System.out.println("Please enter depth of the seat.");
        String b=new Scanner(System.in).nextLine();
        this.w=Float.valueOf(b);
        if (this.w<=0){
            throw new IllegalArgumentException();
        }


    };


    @Override
    public void getPrice() throws IllegalArgumentException{
        System.out.println("Please enter price of the seat.");
        this.p=Float.valueOf(new Scanner(System.in).nextLine());
        if (this.p<0){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean lessThanAv(float [] prices) {
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
    public abstract void descr(float[] prices);

    @Override
    public float findSq() {
        return this.l*this.w;
    }

    @Override
    public String fitSize(float a, float b) throws ArithmeticException{
            if (a<this.l) { ArithmeticException wr=new ArithmeticException("lack of length"); throw wr;}
            else if (b>=this.l) return "It fits either width or length of the room.";
            else return "It fits length of the room.";
    };


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

package by.it.rudzko.jd01_08;

import java.util.Scanner;


public abstract class Table implements IFurniture{

    private float l;
    private float w;

    private float p;

    @Override
    public void getPar() throws IllegalArgumentException{
        System.out.println("Please enter length of the table.");
        String a=new Scanner(System.in).nextLine();
        this.l=Float.valueOf(a);
        if (this.l<=0){
            throw new IllegalArgumentException();
        }
        System.out.println("Please enter width of the table.");
        String b=new Scanner(System.in).nextLine();
        this.w=Float.valueOf(b);
        if (this.w<=0){
            throw new IllegalArgumentException();
        }

    }


    @Override
    public void getPrice() throws IllegalArgumentException{
        System.out.println("Please enter price of the table.");
        this.p=Float.valueOf(new Scanner(System.in).nextLine());
        if (this.p<0){
            throw new IllegalArgumentException();
        }
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

        return this.p<sum/count;
    }

    @Override
    public abstract void descr();

    @Override
    public abstract void descr(float [] prices);

    @Override
    public float findSq() {
        return this.l*this.w;
    }
    /**
     * @param a,b the length and the width of the room
     * @return String
     *
     */
    @Override
    public String fitSize(float a, float b) throws ArithmeticException{
        if (a<this.l){ throw new ArithmeticException("lack of length");}
        String s1="Table fits width of the room.";  String s2="Table doesn't fit width of the room";
        return (b>=this.l) ? s1:s2;
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

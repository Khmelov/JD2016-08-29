package by.it.rudzko.jd01_08;

import java.util.Scanner;


public class CoffeeTable extends Table {

    private float r;
    private float l;
    private String col;

    @Override
    public void getPar() throws IllegalArgumentException{
        System.out.println("Please enter radius of the table.");
        String a=new Scanner(System.in).nextLine();

        this.r=Float.valueOf(a);
        if (this.r<=0){
            throw new IllegalArgumentException();
        }
        this.l=r*2;

    }


    @Override

    public void descr(float [] prices){

        prices[0]=super.getP();
    }

    public void descr() {
        System.out.println("\n\nCoffee Table\nRadius: "+r+".\nPrice: "+super.getP()+".");
    }

    @Override
    public float findSq() {
        return (float)(Math.PI*Math.pow(r,2));
    }

    @Override
    public String fitSize(float a, float b) throws ArithmeticException{
        if (a<this.l){  throw new ArithmeticException("lack of length");}
        String s1="Table fits width of the room.";  String s2="Table doesn't fit width of the room";
       return (b>=this.l)?s1:s2;
    }






}

package by.it.rudzko.jd02_01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Olga Rudzko
 *
 */

public class Shop {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        long t=System.currentTimeMillis();
        int number=1;

        ArrayList<Buyer> b=new ArrayList<Buyer>();
        while (number<200){
            long t2=System.currentTimeMillis();
            Iterator<Buyer> it=b.iterator();
            while (it.hasNext()){                           //removes buyers who left the shop from list
                String s=it.next().getState().toString();
                if(s.equals("TERMINATED"))
                it.remove();
            }

            if (((t2-t)/1000)%60<30) {                      //checks what half of current minute is it
                System.out.println(b.size()+" buyers now in the shop: "+b);
                if(b.size()>10){                            //checks if the number of buyers inside is not more than 10
                    //System.out.println("Sorry, there're "+b.size()+" buyers in the shop. Please wait somebody leaves.");
                    try{
                     for (int i=0; i<b.size(); i++) {
                         if (!b.get(i).getPensioner())
                         {b.get(i).join();                   //joins to the first non-pensioner TIMED-WAITING process
                         break;}
                         else if (i==b.size()-1)
                             b.get(0).join();
                     }
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                } else {
                    int amount = Helper.random(2);
                    for (int i = 0; i < amount; i++) {
                        if (number % 4 != 0) {
                            Buyer x = new Buyer(number++, false);
                            x.start();
                            b.add(x);
                        } else {
                            Buyer x = new Buyer(number++, true);
                            System.out.println(x.toString() + " is a pensioner.");
                            x.start();
                            b.add(x);
                        }
                    }
                }
            } else {
                if (b.size()>30) {
                    System.out.println("Sorry, there're "+b.size()+" buyers in the shop. Please wait somebody leaves.");
                    try{ b.get(0).join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int amount = Helper.random(2);
                    for (int i = 0; i < amount; i++) {
                        if (number % 4 != 0) {
                            Buyer x = new Buyer(number++, false);
                            x.start();
                            b.add(x);
                        } else {
                            Buyer x = new Buyer(number++, true);
                            System.out.println(x.toString() + " is a pensioner.");
                            x.start();
                            b.add(x);
                        }
                    }
                }
            }
            Helper.performing(1000);
        }
    }
}

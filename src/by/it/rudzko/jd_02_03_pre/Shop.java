package by.it.rudzko.jd_02_03_pre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.rudzko.jd_02_03_pre.Cashier.poolCashiers;

/**
 * @author Olga Rudzko
 *
 */

public class Shop {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        long t = System.currentTimeMillis();
        AtomicInteger countBuyers=new AtomicInteger(0);

       ArrayList<Buyer> b=new ArrayList<Buyer>();

        while (countBuyers.get()<Buyer.AMOUNT_OF_BUYERS){
            long t2=System.currentTimeMillis();
            Iterator<Buyer> it=b.iterator();
            while (it.hasNext()){                           //removes buyers who left the shop from list
                String s=it.next().getState().toString();
                if(s.equals("TERMINATED"))
                it.remove();
            }

            if (((t2-t)/1000)%60<30) {                      //checks what half of current minute is it
               // System.out.println(b.size()+" buyers now in the shop: "+b);
                if(b.size()>10){                            //checks if the number of buyers inside is not more than 10
                    System.out.println("Sorry, there're "+b.size()+" buyers in the shop. Please wait somebody leaves.");
                    try{
                     for (int i=0; i<b.size(); i++) {
                         if (!b.get(i).getPensioner())
                         {b.get(i).join();                   //joins to the first non-pensioner RUNNABLE process
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
                        if (countBuyers.incrementAndGet() % 4 != 0) {
                            Buyer x = new Buyer(countBuyers.get(), false);
                            x.start();              b.add(x);
                            } else {
                            Buyer x = new Buyer(countBuyers.get(), true);
                            System.out.println(x.toString() + " is a pensioner.");
                            x.start();              b.add(x);
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
                        if (countBuyers.incrementAndGet() % 4 != 0) {
                            Buyer x = new Buyer(countBuyers.get(), false);
                            x.start();              b.add(x);
                            } else {
                            Buyer x = new Buyer(countBuyers.get(), true);
                            System.out.println(x.toString() + " is a pensioner.");
                            x.start();              b.add(x);
                            }
                    }
                }
            }
            Helper.performing(1000);
        }
        while(Cashier.countServed.get()<Buyer.AMOUNT_OF_BUYERS  && !b.isEmpty()) {
            b.get(0).join();
            }
            poolCashiers.shutdown();
        }
}


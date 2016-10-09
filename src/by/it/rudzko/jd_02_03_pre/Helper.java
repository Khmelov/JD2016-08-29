package by.it.rudzko.jd_02_03_pre;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;



/**
 * @author Olga Rudzko
 */
public class Helper {



    protected static int random(int a, int b) {
        return (int) (Math.random() * (b - a) + 1 + a);
    }

    protected static int random(int a) {
        return (int) (Math.random() * a + 1);
    }

    protected static void performing(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static void createBuyers (int amount, BlockingQueue b){
        for (int i = 0; i < amount; i++) {
            if (Buyer.countBuyers.incrementAndGet() % 4 != 0) {
                Buyer x = new Buyer(Buyer.countBuyers.get(), false);
                x.start();                            b.add(x);
            } else {
                Buyer x = new Buyer(Buyer.countBuyers.get(), true);
                System.out.println(x.toString() + " is a pensioner.");
                x.start();                            b.add(x);
            }
            if (b.remainingCapacity()==0) break;
        }
    }

    protected static void checkBuyers (BlockingQueue b){
        Iterator<Buyer> it = b.iterator();
        while (it.hasNext()) {
            String s = it.next().getState().toString();
            if (s.equals("TERMINATED"))
                it.remove();
        }
    }
}

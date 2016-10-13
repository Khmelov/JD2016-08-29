package by.it.rudzko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Olga Rudzko
 */
public class Helper {

    static private AtomicInteger income = new AtomicInteger(0);

    protected static int random(int a, int b) {
        return (int) (Math.random() * (b - a) + 1 + a);
    }

    protected static int random(int a) {
        return (int) (Math.random() * a + 1);
    }

    static void performing(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void createBuyers(int amount, BlockingQueue<Buyer> b) {
        try {
            for (int i = 0; i < amount; i++) {
                if (Buyer.countBuyers.incrementAndGet() % 4 != 0) {
                    Buyer x = new Buyer(Buyer.countBuyers.get(), false);
                    x.start();
                    b.put(x);
                } else {
                    Buyer x = new Buyer(Buyer.countBuyers.get(), true);
                    System.out.println(x.toString() + " is a pensioner.");
                    x.start();
                    b.put(x);
                }
                if (b.remainingCapacity() == 0) break;
                if (Buyer.countBuyers.get() == Buyer.AMOUNT_OF_BUYERS) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void checkBuyers(BlockingQueue<Buyer> b) {
        Iterator<Buyer> it = b.iterator();
        while (it.hasNext()) {
            String s = it.next().getState().toString();
            if (s.equals("TERMINATED"))
                it.remove();
        }
    }

    static void printBill(Cashier c, int number, Buyer x) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (number - 1) * 30; i++) {
            sb.append(' ');
        }
        Map<String, Double> map = new HashMap<String, Double>(x.choice) {
            @Override
            public String toString() {
                StringBuilder sb1 = new StringBuilder();
                ArrayList<String> list = new ArrayList<>(this.keySet());
                for (int i = 0; i < list.size(); i++) {
                    int l = list.get(i).toCharArray().length;
                    StringBuilder sb2 = new StringBuilder();
                    for (int j = 0; j < 10 - l; j++) {
                        sb2.append(" ");
                    }
                    sb1.append(sb + list.get(i) + sb2 + this.get(list.get(i)) + "\n");
                }
                return sb1.deleteCharAt(sb1.length() - 1).toString();
            }
        };
        System.out.println("\n" + sb + c + " served " + x + ".\n" + sb + "____Bill:____\n" + map);
        StringBuilder col6 = new StringBuilder();
        StringBuilder col7 = new StringBuilder();
        int i = 0;
        while (i < 140 - sb.length()) {
            col6.append(' ');
            i++;
        }
        int j = 0;
        while (j < 15) {
            col7.append(' ');
            j++;
        }
        System.out.println(sb + "--------------" + col6 + "Queue" + col7 + "Income");
        Double bill = 0.0;
        Iterator<Map.Entry<String, Double>> it = x.choice.entrySet().iterator();
        while (it.hasNext()) {
            bill += it.next().getValue();
        }
        double in = ((double) (income.addAndGet((int) (bill * 100)))) / 100;
        System.out.println(sb + "Total     " + bill + col6 + "    " + QueueBuyers.getSize() + col7 + "  " + in + "\n");
    }
}

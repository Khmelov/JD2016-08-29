package by.it.grishechkin.jd02_03;

import java.util.Map;
import java.util.Random;

import static by.it.grishechkin.jd02_03.Runner.doneBuyers;
import static by.it.grishechkin.jd02_03.Runner.plan;

/**
 * Created by Yury on 06.11.2016.
 */
public class Cashier implements Runnable {

    public int num;

    Cashier(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Кассир № " + num;
    }

    @Override
    public void run() {

        System.out.println(this.toString() + " открыл кассу");
        while (doneBuyers < plan) {
            Buyer buyer = BuyerQueue.poll();
            if (buyer != null) {
                synchronized (buyer) {
                    Random random = new Random();
                    System.out.println(this.toString() + " начал обслуживать " + buyer.toString());
                    TaskB.sleep(random.nextInt(random.nextInt(4) + 2) * 1000); // кассир обслуживает от 2 да 4 секунд
                    Double sum = 0.00;
                    for (Map.Entry entry : buyer.bucket.entrySet()) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                        sum += (Double) entry.getValue();
                    }
                    System.out.println(this.toString() + " обслужил " + buyer.toString() + " общая стоимость покупок = " + sum);
                    Runner.doneBuyers++;
                    buyer.notify();
                }
            }
            else TaskB.sleep(1000);
        }
        System.out.println(this.toString() + " закрыл кассу");

    }
}

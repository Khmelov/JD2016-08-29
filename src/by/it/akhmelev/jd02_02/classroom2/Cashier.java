package by.it.akhmelev.jd02_02.classroom2;

import by.it.akhmelev.jd02_01.classroom.*;

public class Cashier implements Runnable{
    @Override
    public void run() {
        while (QueueBuyers.needService()){
            Buyer b=QueueBuyers.extract();
            System.out.println("Start service "+b);
            Helper.sleep(Helper.rnd(1000));
            System.out.println("Billing ... "+b);
            System.out.println("Stop service "+b);
            synchronized (b) {
                b.notify();
            }
        }
        System.out.println("Cashier stop");
        synchronized (Dispatcher.monitorCountCashies){
            Dispatcher.countCashiers--;
        }

    }
}

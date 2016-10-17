package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cashier implements Runnable {
    private int number;
    private double check = 0;
    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public Cashier() {
        this.number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }

    @Override
    public void run() {
        System.out.printf("%s  открыл кассу%n", this);
        while (!Dispatcher.finish()) {
            Buyer b = QueueBuyers.pool();
            if (b != null) {
                synchronized (b) {
                    System.out.println("Доброй пожаловать в Евроопт " + b);
                    Helper.sleep(Helper.rnd(1000));
                    System.out.printf("%s Рассчитываю ... %s%n", this, b);
                    Dispatcher.completeBuyersCount.incrementAndGet();
                    b.iWait = false;
                    b.notify();
                    check = b.totalAmount;
                    sayCheck(b);

                }
            } else
                Helper.sleep(1000);
        }
        System.out.printf("%s закрыл кассу%n", this);
    }

    private void sayCheck(Buyer b) {
        System.out.printf("%s Чек %s - %s ИТОГО: %.2f%n", this, b, b.backet.entrySet(), check);
        double sum = 0;
        for (int i = 0; i < Dispatcher.amount.length; i++) {
            System.out.printf("Кассир №%d %.2f||", i + 1, Dispatcher.amount[i]);
            sum += Dispatcher.amount[i];
        }
        System.out.printf("Кол-во людей в очереди %d", QueueBuyers.queue.size());
        System.out.printf("||Общая выручка магазина %.2f||%n ", sum);
        System.out.printf("%s обслужил покупателя %s%n", this, b);
        Dispatcher.amount[number - 1] += check;
    }
}

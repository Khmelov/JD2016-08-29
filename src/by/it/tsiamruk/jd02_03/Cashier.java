package by.it.tsiamruk.jd02_03;

public class Cashier implements Runnable {
    private int number;

    public Cashier() {
        this.number = ++Dispatcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }

    @Override
    public void run() {

        System.out.printf("%s %d открыл кассу%n", this, number);

        while (QueueBuyers.needService()) {
            Buyer b = QueueBuyers.pool();
            if (b != null)
                synchronized (b) {
                    System.out.println("Доброй пожаловать в Евроопт " + b);
                    Helper.sleep(Helper.rnd(1000));
                    System.out.println("Рассчитываю ... " + b);
                    Dispatcher.completeBuyersCount.incrementAndGet();
                    ++Dispatcher.countCompleteBuyers;
                    b.notify();
                }
            else
                Dispatcher.sleep(1000);
        }
        System.out.printf("%s %d закрыл кассу%n", this, number);
    }
}

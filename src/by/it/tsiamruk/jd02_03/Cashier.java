package by.it.tsiamruk.jd02_03;

public class Cashier implements Runnable {
    private int number;

    public Cashier() {
        this.number = ++Dispatcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Cashier" + number;
    }

    @Override
    public void run() {

        System.out.printf("%s %d открыл кассу%n", this, number);

        while (!Dispatcher.finish()) {
            Buyer b = QueueBuyers.pool();
            if (b != null)
                synchronized (b) {
                    System.out.println("Start service " + b);
                    Helper.sleep(Helper.rnd(1000));
                    System.out.println("Billing ... " + b);
                    b.notify();
                }
            else
                Dispatcher.sleep(1000);
        }
        System.out.println("Cashier handled this Buyer");
//        synchronized (Dispatcher.monitorCountCashies) {
//            Dispatcher.countCashiers--;
//        }
    }
}

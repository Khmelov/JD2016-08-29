package by.it.akhmelev.jd02_03.classroom3;

public class Cashier implements Runnable {

    int number;

    public Cashier() {
        number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {
        while ((Dispatcher.countCashiers.get() == 1 &&
                !Dispatcher.isFinished()
        )
                ) {
            if (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.extract();
                System.out.println(this + "Start service " + buyer);
                Helper.sleep(Helper.rnd(5000));
                System.out.println(this + "Billing ... " + buyer);
                System.out.println(this + "Stop service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        System.out.println(this + " stop");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}

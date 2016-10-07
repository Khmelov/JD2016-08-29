package by.it.tsiamruk.jd02_03;

public class Cashier implements Runnable {

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cashier() {
        number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {

        do {
            if (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.extract();
                System.out.println(this + "Start service " + buyer);
                Helper.sleep(Helper.rnd(1000));
                System.out.println(this + "Billing ... " + buyer);
                System.out.println(this + "Stop service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        while (Dispatcher.needCashiers());
        System.out.println(this + " stop");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}

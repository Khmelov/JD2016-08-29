package by.it.senchenko.jd02_03;

public class Cashier implements Runnable {

    private int number;

    public Cashier() {
        number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {

        System.out.println(this + " открыта");
        System.out.println("Текущий размер очереди = "+QueueBuyers.getSize());

        while (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.extract();
                System.out.println(this + " начинает обслуживать " + buyer);
                Helper.sleep(Helper.rnd(1000));
                System.out.println(this + " рассчитывает " + buyer);
                System.out.println(this + " обслужил " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
                if (!QueueBuyers.needService())
                    Helper.sleep(500);
            }
        System.out.println(this + " закрыта");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Касса №" + number;
    }

    //public int getSum
}

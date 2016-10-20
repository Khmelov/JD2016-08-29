package by.it.vashukevich.jd02_03;

public class Cashier implements Runnable{
    private int number;

    public Cashier() {number = Dispatcher.countCashiers.incrementAndGet();}

    @Override
    public void run() {
        System.out.println(this+" отктрыта+++++++++++++++++++++++");
        System.out.println("Очередь составляет = "+QueueBuyers.getSize()+" человек");

        while (QueueBuyers.needService()) {
            Buyer buyer= QueueBuyers.extract();
            System.out.println(this+" Start service "+buyer);
            Help.sleep(Help.fromTo(1000));
            System.out.println(this+" Billing "+buyer);
            System.out.println(this+" Stop service "+buyer);
            synchronized (buyer){
                buyer.notify();
            }
            if (!QueueBuyers.needService())
                Help.sleep(500);
        }
        System.out.println(this+" закрыта--------------------------");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Касса №" + number;
    }
}

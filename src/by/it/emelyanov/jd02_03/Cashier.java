package by.it.emelyanov.jd02_03;

public class Cashier implements Runnable{
    private int num; //номер кассира

    public Cashier() {
        this.num = ++Dispatcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Кассир-"+num;
    }

    @Override
    public void run() {
        System.out.println(this+" открыл кассу");
        while (!Dispatcher.finish()) {
            Buyer buyer=QueueBuyers.poll();
            if (buyer!=null) //есть клиент, обслуживание
            synchronized (buyer) {
                System.out.println(this+" обслуживает клиента: "+buyer);
                Helper.sleep(Helper.fromTo(2000, 5000));
                System.out.println(this + " обслужил клиента: " + buyer);
                Dispatcher.countCompleteBuyers++;
                Dispatcher.acountCompleteBuyers.incrementAndGet();
                buyer.iWait=false;
                buyer.notify();
            }
            else
                Helper.sleep(1000);
        }
        System.out.println(this+" закрыл кассу");
    }

}

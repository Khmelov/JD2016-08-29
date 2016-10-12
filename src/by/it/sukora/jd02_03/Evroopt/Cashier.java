package by.it.sukora.jd02_03.Evroopt;

public class Cashier implements Runnable {

    private int number;

    public Cashier() {
        number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {
        Helper.Timer t = new Helper.Timer();
        System.out.println(this + " Открыл кассу +++++++++++++++++++++++++++");
        System.out.println("Размер очереди = " + QueueBuyers.getSize());

        while (QueueBuyers.needService()) {
            Buyer buyer = QueueBuyers.extract();
            System.out.println(this + "Начал обслуживание " + buyer);
            Helper.sleep(Helper.rnd(1000));
            System.out.println(this + "Обслуживание ... " + buyer);
            System.out.println(this + "Конец обслуживания! " + buyer);
            System.out.println(t);
            synchronized (buyer) {
                buyer.notify();
            }
            if (!QueueBuyers.needService())
                Helper.sleep(500);
        }
        System.out.println(this + " заканчивает работу -------------------------------");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }
}

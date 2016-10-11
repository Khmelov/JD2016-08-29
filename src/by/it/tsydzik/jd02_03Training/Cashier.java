package by.it.tsydzik.jd02_03Training;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Cashier implements Runnable {
    int cashierNumber;    //номер кассира

    public Cashier() {
        this.cashierNumber = ++Dispatcher.countCashiers;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while (!Dispatcher.finish()) {

            Buyer buyer = QueueBuyers.poll();
            if (buyer != null) {
                synchronized (buyer) {
                    System.out.println(this + " обслуживает клиента: " + buyer);
                    Helper.sleep(Helper.rnd(2000, 5000));
                    System.out.println(this + " обслужил клиента: " + buyer);

                    //увеличим счетчик обслуженных клиентов
                    Dispatcher.countCompleteBuyers.incrementAndGet();
                    buyer.iWait = false;
                    buyer.notify();     //отдаем блокировку обратно покупателю
                }
            } else {
                Helper.sleep(1000);
            }
        }
        System.out.println(this + " закрыл кассу");
    }

    @Override
    public String toString() {
        return "Кассир-" + cashierNumber;
    }


}
